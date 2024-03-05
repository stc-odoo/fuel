package com.reitano.carburanti;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reitano.carburanti.acquisti.acquisti;
import com.reitano.carburanti.vendite.vendite;

@Service
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
		
	public StringBuilder getMounthMargin(List<acquisti> acquisti, List<vendite> vendite) {
		
		List<Margine> marg= this.tableVendite(acquisti, vendite);
		
		StringBuilder str=new StringBuilder();
		
		str.append("Mese\tQuantità\tTotale\t\tMargine\n");
		double sumMargine=0.0;
		double sumQuantità=0.0;
		double sumTotEur=0.0;
		
	
			for(int mese=1; mese<12; mese++) {
					for(int i=0; i<marg.size(); i++) {
						if(mese==Integer.parseInt(marg.get(i).getSell().getData().toString().substring(5, 7))) {
							sumMargine=sumMargine+(marg.get(i).getMargine()*marg.get(i).getSell().getQuantità());
							sumQuantità= sumQuantità+marg.get(i).getSell().getQuantità();
							sumTotEur=sumTotEur+(marg.get(i).getSell().getPu()*marg.get(i).getSell().getQuantità());
						}				
												
					}
					sumQuantità=Math.round(sumQuantità*100);
					sumQuantità=sumQuantità/100;
					String qta= String.valueOf(sumQuantità).replace(".", ",");
					
					sumTotEur=Math.round(sumTotEur*100);
					sumTotEur=sumTotEur/100;
					String tot= String.valueOf(sumTotEur).replace(".", ",");
					
					sumMargine=Math.round(sumMargine*100);
					sumMargine=sumMargine/100;
					String mar= String.valueOf(sumMargine).replace(".", ",");
					
					
					str.append(mese+"\t"+qta+"\t"+tot+"\t"+mar+"\n");
					sumMargine=0;
					sumQuantità=0;
					sumTotEur=0;
					}			
			return str;
	}
		
	}

	

