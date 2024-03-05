package com.reitano.carburanti.vendite;

import java.util.List;


public interface sell_service {
    
	List<vendite> getAllSells();
    
    void saveSell(vendite sell);
    
    vendite getSellById(Integer id);
    
    void deleteSellById(Integer id);

	List<vendite> getStazProd(String stazione, String prodotto);

	
}

