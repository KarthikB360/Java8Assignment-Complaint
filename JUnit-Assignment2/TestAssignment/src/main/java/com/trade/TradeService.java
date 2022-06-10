package com.trade;

//Sample Trade Ids:
//London : 121456903
//Newyork : 12232140
//Tokyo : 12345678
public class TradeService {

	private RegionalDaoManager regionalDaoManager;
	
	public TradeService() {

	}
	
	public TradeService(RegionalDaoManager regionalDaoManager) {
		this.regionalDaoManager = regionalDaoManager;
	}
	
	public TradeDetails getTradeDetails(long tradeId) {
		Region region = getTradeRegion(tradeId);
		System.out.println(region);
		RegionalDao regionalDao = regionalDaoManager.getRegionalDao(region);
		TradeDetails tradeDetails = regionalDao.getTradeDetails(tradeId);
		tradeDetails.setRegion(region);
		return tradeDetails;
	}

	public Region getTradeRegion(long tradeId) {
		System.out.println("id: "+tradeId);
		int regionCode = Integer.parseInt(String.valueOf(String.valueOf(tradeId).charAt(2)));
		switch (regionCode) {
		case 1:
			return Region.LONDON;
		case 2:
			return Region.NEWYORK;
		case 3:
			return Region.TOKYO;
		}
		throw new IllegalArgumentException("Invalid TradeId");
	}
}


