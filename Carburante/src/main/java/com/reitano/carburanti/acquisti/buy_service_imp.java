package com.reitano.carburanti.acquisti;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class buy_service_imp implements buy_service{

	@Autowired
	private buy_rep buy_rep;
	
	@Override
	public List<acquisti> getAllBuy() {
		// TODO Auto-generated method stub
		return buy_rep.findAll(Sort.by("data").ascending());
	}

	@Override
	public void saveBuy(acquisti buy) {
		// TODO Auto-generated method stub
		this.buy_rep.save(buy);
	}

	@Override
	public acquisti getBuyById(Integer id) {
		// TODO Auto-generated method stub
		Optional <acquisti> optional = buy_rep.findById(id);
		acquisti acquisti= null;
		if (optional.isPresent()) {
			acquisti= optional.get();
		}  else {
			throw new RuntimeException("Vendita non trovata");
		}
		
		return acquisti;
	}

	@Override
	public void deleteBuyById(Integer id) {
		// TODO Auto-generated method stub
		this.buy_rep.deleteById(id);
	}
	
	@Override 
	public List<acquisti> findStazProd(String azienda, String prodotto){		
		return this.buy_rep.findbyStazProd(azienda, prodotto);
	}

}
