package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import utils.DBUtils;

public class DBUtilsTest {
	
	@Test
	public void DBUtilsTest(){
		
		Connection conn = DBUtils.getConnection();
		String sql="select *from emp";
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getString("ename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
