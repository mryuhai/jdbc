package Demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import utils.JDBCUtils_v2;

public class JDBCUtilsTest {
	@Test
	public void JDBCUtilsTest(){
		Connection conn=null;
		PreparedStatement prstamt=null;
		ResultSet rs= null;
		try {
			conn=JDBCUtils_v2.getConnection();
			String sql= "select*from emp where empno=?";
			prstamt=conn.prepareStatement(sql);
			prstamt.setInt(1,7369);
			rs=	prstamt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_v2.close(conn, prstamt, rs);
			 
		}
		
		
	}
}
