package com.trade;

import javax.sql.DataSource;

import com.ds.MySqlDataSource;

public class LondonDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new MySqlDataSource();
	}

}
