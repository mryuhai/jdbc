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
		 //ͨ�������ȡ���ص�ַ
		 //ͨ����ַ��ȡ��
		 InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		 //����һ��Properties����
		 
		 Properties prp = new Properties();
		 try {
			 //ͨ��load ����������  ���������б�
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
