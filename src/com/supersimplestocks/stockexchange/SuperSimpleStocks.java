package com.supersimplestocks.stockexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.supersimplestocks.stockexchange.domain.Stock;
import com.supersimplestocks.stockexchange.util.StockUtil;

public class SuperSimpleStocks {

	public static void main(String[] args) {
		SuperSimpleStocks superSimpleStocks = new SuperSimpleStocks();
		superSimpleStocks.promptOperation();
//		DataHolder dataHolder = DataHolder.getInstance();
//		Stock stock = dataHolder.getStock("TEA");
//		System.out.println(stock);
	}
	
	private void promptOperation() {
		
		String stockSymbol = getInput("Please enter the stock symbol : ");
		DataHolder dataHolder = DataHolder.getInstance();
		Stock stock = null;
		if(stockSymbol != null){
			stock = dataHolder.getStock(stockSymbol.toUpperCase());
		}
		
		if(stock != null){
			System.out.println(stock);
			promptMarketPrice(stock);
		} else {
			System.out.println("Invalid stock symbol! ");
			promptOperation();
		}
		
		fetchStockPerformance(stock);
		
	}
	
	private void promptMarketPrice(Stock stock) {
		String marketPriceStr = getInput("Please enter the market price for " +  stock.getStockSymbol() + ": ");
		double marketPrice = 0;
		try {
			marketPrice = Double.parseDouble(marketPriceStr);
			stock.setMarketPrice(marketPrice);
		} catch (Exception e) {
			System.out.println("Invalid Market Price!");
			promptMarketPrice(stock);
		}
		
	}

	private void fetchStockPerformance(Stock stock) {
		double dividendYield = 0;
		if("Common".equals(stock.getType())){
			dividendYield = StockUtil.getDivYield(stock.getLastDividend(), stock.getMarketPrice());
		} else if("Preferred".equals(stock.getType())){
			dividendYield = StockUtil.getDivYield(stock.getFixedDividend(), stock.getParValue(), stock.getMarketPrice());
		}
		
		double peRatio = StockUtil.getPERatio(stock.getLastDividend(), stock.getMarketPrice());
		
		System.out.println("Dividend Yield : " + dividendYield);
		System.out.println("P/E Ratio : " + peRatio);
	}

	private String getInput(String description) {
	    System.out.print(description + ": ");
	    String input = null;

	    InputStreamReader stream = null;
	    BufferedReader reader = null;
	    try {
	        // Open a stream to stdin
	        stream = new InputStreamReader(System.in);

	        // Create a buffered reader to stdin
	        reader = new BufferedReader(stream);

	        // Try to read the string
	        input = reader.readLine();           
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 

	    return input;
	}

}
