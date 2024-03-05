package com.reitano.carburanti;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		
		/*Sperazione Vendite
			for(int i=0; i<auxS.size(); i++) {
				if (auxS.get(i).getStazione().equals(azienda)) {
						if(auxS.get(i).getProdotto().equals("Benzina")) {
							auxBenz.add(auxS.get(i));
						}else if (auxS.get(i).getProdotto().equals("Diesel")) {
							auxDies.add(auxS.get(i));
						}else {
							auxSup.add(auxS.get(i));
						}
				}
			}*/
				
			
			
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
	

}