package com.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ds.MySqlDataSource;
import com.ds.OracleDataSource;
import com.ds.SqlServerDataSource;
import com.trade.LondonDao;
import com.trade.NewyorkDao;
import com.trade.RegionalDao;
import com.trade.TokyoDao;
import com.trade.TradeDetails;

@ExtendWith(MockitoExtension.class)
class RegionDaoTest {

	@Mock
	RegionalDao dao;

	@Test
	public void test_getTradeDetails() {
		Mockito.when(dao.getTradeDetails(Mockito.any(Long.class))).thenReturn(new TradeDetails());
		TradeDetails tradeDetails = dao.getTradeDetails(123);
		assertNotNull(tradeDetails);
	}

	@Test
	public void getTradeDetailsShouldThrowException() {
		Mockito.when(dao.getTradeDetails(Mockito.any(long.class))).thenThrow(RuntimeException.class);
		Executable executable = () -> dao.getTradeDetails(122);
		assertThrows(RuntimeException.class, executable);
	}

	@Test
	public void londonDaoTest() {
		LondonDao dao = new LondonDao();
		DataSource ds = dao.getDataSource();
		assertTrue(ds instanceof MySqlDataSource);
	}

	@Test
	public void newYorkDaoTest() {
		NewyorkDao dao = new NewyorkDao();
		DataSource ds = dao.getDataSource();
		assertTrue(ds instanceof OracleDataSource);
	}

	@Test
	public void tokyoDaoTest() {
		TokyoDao dao = new TokyoDao();
		DataSource ds = dao.getDataSource();
		assertTrue(ds instanceof SqlServerDataSource);
	}

}
