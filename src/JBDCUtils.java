import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class JBDCUtils {
	
	private static String driver=null;
	private static String url=null;
	private static String uersname=null;
	private static String password=null;
	static {
		ResourceBundle rb= ResourceBundle.getBundle("db");
		driver= rb.getString("driver");
		url= rb.getString("url");
		uersname= rb.getString("uersname");
		password= rb.getString("password");
		try {
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static  Connection getConnection(){
		
		Connection conn= null;
		try {
			conn = DriverManager.getConnection(url, uersname, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstamt, ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(pstamt!=null)
				pstamt.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
