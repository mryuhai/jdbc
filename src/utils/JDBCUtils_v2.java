package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class JDBCUtils_v2 {
	private static String driver =null;
	private static String url =null;
	private static String username =null;
	private static String password =null;
	
	static{
		
		ResourceBundle rd=ResourceBundle.getBundle("db");
		driver=rd.getString("driver");
		url=rd.getString("url");
		username=rd.getString("username");
		password=rd.getString("password");
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password) ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstamt,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(pstamt!=null)
				pstamt.close();
			if(conn!=null)
				conn.close();
			System.out.println("×ÊÔ´ÊÍ·Å");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
