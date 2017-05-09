import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

import utils.C3P0Utils;

public class Demo {
	@Test
	public void C3P0UtilsTest() {
		
		try {
			Connection conn = C3P0Utils.getConn();
			String sql="select *from emp";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs1 = statement.executeQuery();
			if(rs1.next()){
				System.out.println(rs1.getInt("empno")+"--"+rs1.getString("ename"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
}
