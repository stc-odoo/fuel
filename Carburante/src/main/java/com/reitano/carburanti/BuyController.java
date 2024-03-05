package com.reitano.carburanti;
import com.reitano.carburanti.acquisti.*;
import com.reitano.carburanti.vendite.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyController {

	@Autowired
	private buy_service buy_s;
	
	@GetMapping("/buy")
	public String index_buy(Model model) {
		acquisti acquisti=new acquisti();
		List <acquisti> verga= new ArrayList<acquisti>();
		List <acquisti> stazione= new ArrayList<acquisti>();
		List <acquisti> aux= buy_s.getAllBuy();
		
		/*List <acquisti> aux1= buy_s.findStazProd("Verga", "Benzina");
		for(int k=0; k<aux1.size(); k++) {System.out.println(aux1.get(k).getId());}*/
		
		for (int i=0; i<aux.size(); i++) {
			if(aux.get(i).getStazione().equals("Verga")) {
				verga.add(aux.get(i));
			}else if (aux.get(i).getStazione().equals("Stazione"))
				stazione.add(aux.get(i));
		}
		
				
		model.addAttribute("buy",acquisti);
		model.addAttribute("buyListVerga", verga);
		model.addAttribute("buyListStazione", stazione);
		return "buy";
	}
	
	@PostMapping("/save_buy")
	public String save_buy(@ModelAttribute acquisti buy){
		buy_s.saveBuy(buy);
		return "redirect:/buy";
	}
	
	@GetMapping("/delete_buy/{id}")
	public String delete_buy(@PathVariable Integer id){
		buy_s.deleteBuyById(id);
		return "redirect:/buy";
	}
	
	@GetMapping("/update_buy/{id}")
	public String update_buy(@PathVariable Integer id, Model model) {
		acquisti acquisti= this.buy_s.getBuyById(id);
		model.addAttribute("buy", acquisti);
		model.addAttribute("buyList", acquisti);
		
		return "update_buy";
	}
	

}
