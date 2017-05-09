package utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	 
	//获取 connection 对象（通过dataSource）。
	public static Connection  getConn(){
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	// 获取 dataSource对象
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
