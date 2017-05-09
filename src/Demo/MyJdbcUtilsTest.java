package Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.JDBCUtils_v1;

public class MyJdbcUtilsTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement pstemt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils_v1.getConnection();
			String sql = "select *from emp";
			pstemt = conn.createStatement();
			rs = pstemt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getString(4));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void TestmJDBCUtils() {

		Connection conn = null;
		PreparedStatement pstemt = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils_v1.getConnection();
			String sql = "select *from pod";
			pstemt = conn.prepareStatement(sql);
			rs = pstemt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id") + "--" + rs.getShort("pname") + "--" + rs.getString("wroke")
						+ "--" + rs.getString("pirce"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v1.closeLiu(conn, pstemt, rs);
		}

	}
	@Test
	public void Array() {
		final ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		List list = (List) java.lang.reflect.Proxy.newProxyInstance(MyJdbcUtilsTest.class.getClassLoader(),
				arr.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String name = method.getName();
						if ("add".equals(name)) {
							System.out.println("不能添加了");
							return false;
						}
						Object invoke = method.invoke(arr, args);
						return invoke;
					}
				});
		System.out.println(list.toString());
	}
}
