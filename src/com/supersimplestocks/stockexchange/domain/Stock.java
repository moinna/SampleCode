package com.supersimplestocks.stockexchange.domain;

public class Stock implements Comparable<Stock> {
	
	private String stockSymbol;
	private String type;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private double marketPrice;
	
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	
	@Override
	public int compareTo(Stock o) {
		
		if(o.stockSymbol == null || this.stockSymbol == null) return -1;
		
		if(this.stockSymbol.equalsIgnoreCase(o.stockSymbol)){
			return 0;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("Stock Symbol : ");
		sb.append(this.stockSymbol);
		sb.append("\t\t");
		sb.append("Type : ");
		sb.append(this.type);
		sb.append("\t\t");
		sb.append("Last Dividend : ");
		sb.append(this.lastDividend);
		sb.append("\t\t");
		sb.append("Fixed Dividend : ");
		sb.append(this.fixedDividend);
		sb.append("\t\t");
		sb.append("Par Value : ");
		sb.append(this.parValue);
		
		return sb.toString();
	}
	
}
