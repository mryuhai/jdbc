package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


@SuppressWarnings("static-access")
public class DBUtils {
		
	
	private static DataSource datasursce;
	 static {
		 //通过反射获取本地地址
		 //通过地址获取流
		 InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		 //创建一个Properties对象
		 
		 Properties prp = new Properties();
		 try {
			 //通过load 方法连接流  地区属性列表。
			 prp.load(is);
			 
			 datasursce =  new BasicDataSourceFactory().createDataSource(prp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		 
	 }
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
		conn=datasursce.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	} 
	
	public static DataSource getDataSource(){
		return datasursce;
	}
	
}
