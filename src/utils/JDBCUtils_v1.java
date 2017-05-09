package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
public class JDBCUtils_v1 {
	
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	static{
		try {
			ResourceBundle bd = ResourceBundle.getBundle("db");
			driver= bd.getString("driver");
			url=bd.getString("url");
			username=bd.getString("username");
			password= bd.getString("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	} 
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password );
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return conn;
		
	}
	
	//关闭流 
	public static void closeLiu( Connection conn,Statement pstemt,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(pstemt!=null)
				pstemt.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("资源已经释放！！");
	}
}
