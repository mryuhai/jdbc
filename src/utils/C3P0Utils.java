package utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	 
	//��ȡ connection ����ͨ��dataSource����
	public static Connection  getConn(){
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	// ��ȡ dataSource����
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
