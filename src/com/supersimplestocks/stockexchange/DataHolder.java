package com.supersimplestocks.stockexchange;

import java.util.ArrayList;
import java.util.List;

import com.supersimplestocks.stockexchange.domain.Stock;

/**
 *  
 * This is just a simple data holder class
 * as there is no database or a service integration to get the stocks data.
 * 
 * @author moint
 *
 */
public class DataHolder {
	
	private static DataHolder _instance = null;
	
	public static final String _GLOBAL_BEVERAGE_STOCK_EXCHANGE = "Glabal Beverage Stock Exchange";
	
	private static List<Stock> _stocks = new ArrayList<Stock>();
	
	private DataHolder(){
		Stock teaStock = new Stock();
		teaStock.setStockSymbol("TEA");
		teaStock.setType("Common");
		teaStock.setLastDividend(0);
		teaStock.setParValue(100);
		
		_stocks.add(teaStock);
		
		Stock popStock = new Stock();
		popStock.setStockSymbol("POP");
		popStock.setType("Common");
		popStock.setLastDividend(8);
		popStock.setParValue(100);
		
		_stocks.add(popStock);
		
		Stock aleStock = new Stock();
		aleStock.setStockSymbol("ALE");
		aleStock.setType("Common");
		aleStock.setLastDividend(23);
		aleStock.setParValue(60);
		
		_stocks.add(aleStock);
		
		Stock ginStock = new Stock();
		ginStock.setStockSymbol("GIN");
		ginStock.setType("Preferred");
		ginStock.setLastDividend(8);
		ginStock.setFixedDividend(2);
		ginStock.setParValue(100);
		
		_stocks.add(ginStock);
		
		Stock joeStock = new Stock();
		joeStock.setStockSymbol("JOE");
		joeStock.setType("Common");
		joeStock.setLastDividend(13);
		joeStock.setParValue(250);
		
		_stocks.add(joeStock);
		
		/*
		System.out.println("=============================================================================");
		for(Stock stock : _stocks){
			System.out.println("Stock Symbol\t\tType\t\tLast Dividend\t\tFixed Dividend\t\tPar Value");
			System.out.println(stock.getStockSymbol() +"\t\t\t" + stock.getType() + "\t\t" 
			+ stock.getLastDividend() + "\t\t\t" + stock.getFixedDividend() + "\t\t\t" + stock.getParValue());
		}
		System.out.println("=============================================================================");
		*/
	}
	
	public static DataHolder getInstance(){
		
		if(_instance == null){
			_instance = new DataHolder();
		}
		
		return _instance;
	}
	
	/**
	 * Get the stock details for the stock symbol
	 * 
	 * @param stockSymbol
	 * @return
	 */
	public Stock getStock(String stockSymbol){
		
		for(Stock stock : _stocks){
			if(stock.getStockSymbol().equalsIgnoreCase(stockSymbol)){
				return stock;
			}
		}
		
		return null;
	}
	
}
