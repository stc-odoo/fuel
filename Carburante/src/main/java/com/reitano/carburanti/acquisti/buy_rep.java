package com.reitano.carburanti.acquisti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface buy_rep extends JpaRepository<acquisti,Integer>{

	@Query(value= "SELECT * FROM acquisti WHERE stazione=?1 and prodotto=?2 ORDER BY data_a", nativeQuery=true)
	List<acquisti> findbyStazProd(String azienda, String prodotto);

}
