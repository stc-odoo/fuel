package com.reitano.carburanti.vendite;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vendite")
public class vendite {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)	 
	 private Integer id_vendita;
	 
	 @Column(name="prodotto")
	 private String prodotto;
	 
	 @Column(name="quantità")
	 private Double quantità;
	 
	 @Column(name="pu")
	 private Double pu;
	 
	 @Column(name="data")
	 private Date data;
	 
	 @Column(name="stazione")
	 private String stazione;

	public Integer getId() {
		return id_vendita;
	}

	public void setId(Integer id) {
		this.id_vendita = id;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public Double getQuantità() {
		return quantità;
	}

	public void setQuantità(Double quantità) {
		this.quantità = quantità;
	}

	public Double getPu() {
		return pu;
	}

	public void setPu(Double pu) {
		this.pu = pu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStazione() {
		return stazione;
	}

	public void setStazione(String stazione) {
		this.stazione = stazione;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
