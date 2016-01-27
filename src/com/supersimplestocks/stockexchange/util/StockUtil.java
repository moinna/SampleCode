package com.supersimplestocks.stockexchange.util;

public class StockUtil {
	
	/**
	 * 
	 * 
	 * @param lastDividend
	 * @param marketPrice
	 * @return
	 */
	public static double getDivYield(double lastDividend, double marketPrice){
		if(lastDividend == 0 || marketPrice == 0 ) return 0;
		return lastDividend/marketPrice;
	}
	
	/**
	 * 
	 * 
	 * @param fixedDividend
	 * @param parValue
	 * @param marketPrice
	 * @return
	 */
	public static double getDivYield(double fixedDividend, double parValue, double marketPrice){
		if(fixedDividend == 0 || parValue == 0 || marketPrice == 0) return 0;
		return (fixedDividend/100*parValue)/marketPrice;
	}
	
	/**
	 * 
	 * @param lastDividend
	 * @param marketPrice
	 * @return
	 */
	public static double getPERatio(double lastDividend, double marketPrice){
		if(lastDividend == 0 || marketPrice == 0) return 0;
		return marketPrice/lastDividend;
	}
}
