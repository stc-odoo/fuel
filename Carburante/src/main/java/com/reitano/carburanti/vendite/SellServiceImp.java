package com.reitano.carburanti.vendite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SellServiceImp implements sell_service{

	@Autowired
	private sell_rep sellRep;
	
	@Override
	public List<vendite> getAllSells() {
		// TODO Auto-generated method stub
		return sellRep.findAll(Sort.by("data").ascending());
	}

	@Override
	public void saveSell(vendite sell) {
		// TODO Auto-generated method stub
		this.sellRep.save(sell);
	}

	@Override
	public vendite getSellById(Integer id) {
		// TODO Auto-generated method stub
		Optional <vendite> optional = sellRep.findById(id);
		vendite vendite= null;
		if (optional.isPresent()) {
			vendite = optional.get();
		}  else {
			throw new RuntimeException("Vendita non trovata");
		}
		
		return vendite;
	}

	@Override
	public void deleteSellById(Integer id) {
		// TODO Auto-generated method stub
		this.sellRep.deleteById(id);
	}
	
	@Override
	public List<vendite> getStazProd(String stazione, String prodotto){
		return this.sellRep.findbyStazione(stazione,prodotto);
	}

}
