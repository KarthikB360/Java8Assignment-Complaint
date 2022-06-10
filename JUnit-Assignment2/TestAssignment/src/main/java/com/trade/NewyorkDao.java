package com.trade;

import javax.sql.DataSource;

import com.ds.OracleDataSource;

public class NewyorkDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new OracleDataSource();
	}

}
