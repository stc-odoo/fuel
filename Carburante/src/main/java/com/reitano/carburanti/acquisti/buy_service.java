package com.reitano.carburanti.acquisti;

import java.util.List;


public interface buy_service {
	
	List<acquisti> getAllBuy();
    
    void saveBuy(acquisti buy);
    
    acquisti getBuyById(Integer id);
    
    void deleteBuyById(Integer id);

	List<acquisti> findStazProd(String azienda, String prodotto);
}
