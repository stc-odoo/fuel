package com.reitano.carburanti;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reitano.carburanti.acquisti.*;
import com.reitano.carburanti.vendite.sell_service;
import com.reitano.carburanti.vendite.vendite;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ReiController {
	
	@Autowired()
	private sell_service sellService;
	
	@Autowired
	private buy_service buyService;

	@GetMapping("/")
	public String getIndex(@RequestParam(defaultValue = "") String azienda,@RequestParam(defaultValue = "") String tipo,
			Model model
			) {
		
		azienda="Stazione";
		List<Margine> diesel= new Margine().tableVendite(buyService.findStazProd(azienda, "DIESEL"), this.sellService.getStazProd(azienda, "DIESEL"));
		List<Margine> benzina= new Margine().tableVendite(buyService.findStazProd(azienda, "BENZINA"), this.sellService.getStazProd(azienda, "BENZINA"));
		List<Margine> sup= new Margine().tableVendite(buyService.findStazProd(azienda, "S-DIESEL"), this.sellService.getStazProd(azienda, "S-DIESEL"));
		
		String ListBenz=azienda + "\n\n";
		Double sumQ=0.0;
		Double sumT=0.0;
		Double sumM=0.0;
		ArrayList<String> mese=new ArrayList<String>();

		System.out.println("Benzina "+azienda);
		mese.add("Benzina "+azienda);
		for (int m=1; m<13; m++) {			
			for (int benz=0; benz<benzina.size();benz++) {			
				if (m==Integer.parseInt(benzina.get(benz).getSell().getData().toString().substring(5, 7))) {
					sumQ= benzina.get(benz).getSell().getQuantità() + sumQ;
					sumM= (benzina.get(benz).getMargine()*benzina.get(benz).getSell().getQuantità()) + sumM;
				}					
			}
			sumQ=(double) Math.round(sumQ*100);
			sumQ=sumQ/100;
			
			sumM=(double) Math.round(sumM*100);
			sumM=sumM/100;
			
			System.out.print("Mese: "+m+" Quantità Venduta: "+sumQ+" Margine Totale= "+sumM+"\n");
			mese.add("Mese: "+String.valueOf(m) +". Quantità Venduta: "+String.valueOf(sumQ)+". Margine Totale= "+String.valueOf(sumM));
			sumQ=0.0;
			sumM=0.0;
		}
		
		model.addAttribute("stazione", mese);
				
		return "index";
		}
	
	@GetMapping("/greeting")
	public String getVendite(Model model, @RequestParam(defaultValue ="") String azienda) { 
		vendite v=new vendite();
		v.setStazione(azienda);
	
		List<Margine> diesel= new Margine().tableVendite(buyService.findStazProd(azienda, "DIESEL"), this.sellService.getStazProd(azienda, "DIESEL"));
		List<Margine> benzina= new Margine().tableVendite(buyService.findStazProd(azienda, "BENZINA"), this.sellService.getStazProd(azienda, "BENZINA"));
		List<Margine> sup= new Margine().tableVendite(buyService.findStazProd(azienda, "S-DIESEL"), this.sellService.getStazProd(azienda, "S-DIESEL"));
		
		//List<vendite> auxBenz=sellService.getStazProd(azienda, "Benzina");
		List<Margine> auxBenz=benzina;
		List<Margine> auxDies=diesel;
		List<Margine> auxSup=sup;		
						
		model.addAttribute("listSellVerga", auxBenz);
		model.addAttribute("listDiesel", auxDies);
		model.addAttribute("listSup", auxSup);
		model.addAttribute("sell", v);
		return "greeting";
		}
	
	
	@PostMapping("/save")
    public String saveSell(@ModelAttribute("sell")vendite vendite, @RequestParam(defaultValue ="") String azienda) {		
        // save employee to database
        sellService.saveSell(vendite);
		System.out.println(vendite.getStazione());
        return "redirect:/greeting?azienda="+vendite.getStazione();
    }
	
	@GetMapping("/deleteSell/{id}")
	public String deleteEmployee(@PathVariable Integer id) {

	        // call delete employee method
			String par= this.sellService.getSellById(id).getStazione();
	        this.sellService.deleteSellById(id);
	        return "redirect:/greeting?azienda="+par;
	    }
	
	@GetMapping("/update_sell/{id}")
    public String update(@PathVariable Integer id, Model model) {		
		vendite aux= sellService.getSellById(id);
		model.addAttribute("sell", aux);
		model.addAttribute("listSellVerga", aux);
		List<vendite> verga= sellService.getStazProd("Stazione", "Diesel");
		
        return "update_sell";
    }
	
	@GetMapping("/css/carburante.css")
    public String carcss() {		
	
        return "/css/carburante.css";
    }
	
	@GetMapping("/js/carburante.js")
    public String carjs() {		
	
        return "/js/carburante.js";
    }
	
	@GetMapping("/export")
	public ResponseEntity<byte[]> Export(@RequestParam(defaultValue ="") String azienda, @RequestParam(defaultValue ="") String carb) throws IOException{
		
		System.out.println(azienda + carb + "test");
		List<Margine> diesel= new Margine().tableVendite(buyService.findStazProd(azienda, "DIESEL"), this.sellService.getStazProd(azienda, "DIESEL"));
		List<Margine> benzina= new Margine().tableVendite(buyService.findStazProd(azienda, "BENZINA"), this.sellService.getStazProd(azienda, "BENZINA"));
		List<Margine> sup= new Margine().tableVendite(buyService.findStazProd(azienda, "S-DIESEL"), this.sellService.getStazProd(azienda, "S-DIESEL"));
		Margine servMar=new Margine();
		
		StringBuilder csvContent= new StringBuilder();
		csvContent.append(azienda + " "+carb +"\n");
		csvContent.append(servMar.getMounthMargin(buyService.findStazProd(azienda, carb), this.sellService.getStazProd(azienda, carb)));
		/*csvContent.append("id\tdata\tquantità;PU;Totale;Margine;MarginTot");
		
		for(Margine margine: benzina) {
			csvContent.append(margine.getSell().getId()).append("\t").append("\n");
		}*/

		Path tempFile = Files.createTempFile("margine"+azienda, ".txt");
		Files.write(tempFile,  csvContent.toString().getBytes());
		
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "margine"+azienda+".txt");
		
		File file=tempFile.toFile();
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream fis= new FileInputStream(file);
		fis.read(fileContent);
		fis.close();
		
		
		return ResponseEntity.ok().headers(headers).body(fileContent);
	}
	

}