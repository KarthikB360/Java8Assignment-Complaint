package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trade.LondonDao;
import com.trade.Region;
import com.trade.RegionalDao;
import com.trade.RegionalDaoManager;
import com.trade.TradeDetails;
import com.trade.TradeService;

@ExtendWith(MockitoExtension.class)
class TradeServiceTest {

	@Mock
	RegionalDaoManager regionalDaoManager;

	@Mock
	RegionalDao dao;

	@InjectMocks
	TradeService tradeService;

	@Test
	public void test_getTradeDetails() {
		Mockito.when(tradeService.getTradeRegion(123456)).thenReturn(Region.LONDON);
		Mockito.when(regionalDaoManager.getRegionalDao(Region.LONDON)).thenReturn(new LondonDao());
		Mockito.when(dao.getTradeDetails(Mockito.any(Long.class))).thenReturn(new TradeDetails());
		Mockito.when(tradeService.getTradeDetails(123456)).thenReturn(new TradeDetails());

		TradeDetails actualTradeDetails = tradeService.getTradeDetails(123456);
		System.out.println("Obj: " + actualTradeDetails);

		assertNotNull(actualTradeDetails);
	}

	@Test
	public void test_getTradeRegionLondonCheck() {
		TradeService service = new TradeService();
		Region region = service.getTradeRegion(121456903);

		assertEquals(Region.LONDON, region);
	}

	@Test
	public void test_getTradeRegionNewyorkCheck() {
		TradeService service = new TradeService();
		Region region = service.getTradeRegion(12232140);

		assertEquals(Region.NEWYORK, region);
	}

	@Test
	public void test_getTradeRegionTokyoCheck() {
		TradeService service = new TradeService();
		Region region = service.getTradeRegion(12345678);

		assertEquals(Region.TOKYO, region);
	}

	@Test
	public void test_getTradeRegionExceptionCheck() {
		TradeService service = new TradeService();
		Executable exe = () -> service.getTradeRegion(7777777);
		assertThrows(IllegalArgumentException.class, exe);
	}
}
