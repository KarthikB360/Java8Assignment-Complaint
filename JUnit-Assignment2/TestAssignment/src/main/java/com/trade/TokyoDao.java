package com.trade;

import javax.sql.DataSource;

import com.ds.SqlServerDataSource;

public class TokyoDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new SqlServerDataSource();
	}

}
