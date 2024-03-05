package com.reitano.carburanti.vendite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface sell_rep extends JpaRepository<vendite, Integer>{
	
	@Query(value="SELECT * FROM vendite WHERE stazione=?1 and prodotto=?2 ORDER BY data", nativeQuery=true)
	List<vendite> findbyStazione(String stazion, String prodotto);
	
	}