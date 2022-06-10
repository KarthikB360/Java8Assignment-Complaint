package com.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.trade.LondonDao;
import com.trade.NewyorkDao;
import com.trade.Region;
import com.trade.RegionalDao;
import com.trade.RegionalDaoManager;
import com.trade.TokyoDao;


class RegionalDaoManagerTest {
	
	RegionalDaoManager daoManager = new RegionalDaoManager();

	@Test
	public void test_getTradeRegionForLondonSuccess() {

		RegionalDao regionalDao = daoManager.getRegionalDao(Region.LONDON);
		assertTrue(regionalDao instanceof LondonDao);
	}

	@Test
	public void test_getTradeRegionForLondonFailed() {

		RegionalDao regionalDao = daoManager.getRegionalDao(Region.LONDON);
		assertFalse(regionalDao instanceof TokyoDao);
	}

	@Test
	public void test_getTradeRegionForNewYorkSuccess() {

		RegionalDao regionalDao = daoManager.getRegionalDao(Region.NEWYORK);
		assertTrue(regionalDao instanceof NewyorkDao);
	}

	@Test
	public void test_getTradeRegionForTokyoSuccess() {

		RegionalDao regionalDao = daoManager.getRegionalDao(Region.TOKYO);
		assertTrue(regionalDao instanceof TokyoDao);
	}
	
	@Test
	public void test_getTradeRegionExceptionCheck() {

		Executable exe = () -> daoManager.getRegionalDao(Region.valueOf(""));
		assertThrows(IllegalArgumentException.class, exe);
	}
}
