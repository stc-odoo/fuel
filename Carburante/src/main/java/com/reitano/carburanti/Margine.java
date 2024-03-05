package com.reitano.carburanti;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.reitano.carburanti.acquisti.acquisti;
import com.reitano.carburanti.vendite.vendite;

public class Margine{
	private vendite	sell;
	private double margine;
	private acquisti buy;
	
	public Margine(vendite sell, double margine) {
		this.sell = sell;
		this.margine = margine;
	
	}
	
	public Margine() {
	
	}

	public acquisti getBuy() {
		return buy;
	}

	public void setBuy(acquisti buy) {
		this.buy = buy;
	}

	public vendite getSell() {
		return sell;
	}

	public void setSell(vendite sell) {
		this.sell = sell;
	}

	public double getMargine() {
		return margine;
	}

	public void setMargine(double margine) {
		this.margine = margine;
	}
	
	public List<Margine> tableVendite(List<acquisti> acquisti, List<vendite> vendite ){
		double serbatoio;
		serbatoio=0;
		
		
		List<Margine> aux= new ArrayList<Margine>();
		
		Iterator<acquisti> acq= acquisti.iterator();
		Iterator<vendite> ven= vendite.iterator();
		
		while (acq.hasNext()) {
			acquisti aaux= acq.next();
			serbatoio=serbatoio+aaux.getQuantità();
			
			while(ven.hasNext()) {
				double marg=0;
				vendite vaux= ven.next();
				marg= (vaux.getPu()*100/122)-aaux.getPu();
				marg=Math.round(marg*10000000);
				marg=marg/10000000;
				serbatoio=serbatoio-vaux.getQuantità();
				aux.add(new Margine(vaux, marg));
				if(serbatoio<=0) {
					break;
				}
				
			}
		}
			/*prosegue iter senza calcolo margine*/
			while(ven.hasNext()) {
				double marg=-10;
				vendite vaux= ven.next();
				aux.add(new Margine(vaux, marg));				
			}

		
		
		return aux;
	}
		
	
}
