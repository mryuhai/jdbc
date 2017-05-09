package Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.JDBCUtils_v1;

public class JDBCUtilsTest {
	
	@Test
	public void testJDBCUtils(){
		
		Connection conn=null;
		PreparedStatement pstemt=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils_v1.getConnection();
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			pstemt = conn.prepareStatement(sql);
			pstemt.setInt(1, 7903);
			pstemt.setString(2, "小红");
			pstemt.setString(3, "服务员");
			pstemt.setInt(4,0);
			pstemt.setString(5, "1985-02-10");
			pstemt.setInt(6, 1890);
			pstemt.setInt(7, 200);
			pstemt.setInt(8, 10);
			int rows = pstemt.executeUpdate();
			if(rows>0){
				System.out.println("添加成功");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_v1.closeLiu(conn, pstemt, rs);
		}
	}
	
	@Test
	public void testJdbcUtils(){
		Connection conn=null;
		PreparedStatement pstemt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils_v1.getConnection();
			String sql= "alter table map_v1 add jvgprice varchar(32)";
			pstemt = conn.prepareStatement(sql);
			int i = pstemt.executeUpdate();
			if(i>0){
				System.out.println("添加列成功");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_v1.closeLiu(conn, pstemt, rs);
		}
	}
	
	@Test
	public void addConnectionId(){
		Connection conn=null;
		PreparedStatement ptemt=null;
		ResultSet rs=null;
		try {
			conn= JDBCUtils_v1.getConnection();
			String sql="update map_v1 set jvgprice=? where id=? ";
			ptemt=conn.prepareStatement(sql);
			ptemt.setString(1, "8900");
			ptemt.setInt(2, 2);
			int i = ptemt.executeUpdate();
			if(i>0){
				System.out.println("修改成功！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_v1.closeLiu(conn, ptemt, rs);
		}
	}
	
	@Test
	public void addConnectionId_v1(){
		Connection conn= null;
		PreparedStatement pstemt=null;
		ResultSet rs=null;
		
		try {
			conn= JDBCUtils_v1.getConnection();
			String sql = "insert into map_v1 values(?,?,?,?,?)";
			pstemt=conn.prepareStatement(sql);
			pstemt.setInt(1, 4);
			pstemt.setString(2, "日用百货");
			pstemt.setString(3, "ry");
			pstemt.setString(4, "ry");
			pstemt.setInt(5, Integer.valueOf("10"));
			int i = pstemt.executeUpdate();
			if(i>0){
				
				System.out.println("添加成功！");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_v1.closeLiu(conn, pstemt, rs);
		}
	}
	@Test
	public void deleteConnteicById(){
		Connection conn= null;
		PreparedStatement pstemt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils_v1.getConnection();
			String sql = "delete from map_v1 where id=?";
			pstemt = conn.prepareStatement(sql);
			pstemt.setInt(1, 3);
			int e = pstemt.executeUpdate();
			if(e>0){
				System.out.println("删除了");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_v1.closeLiu(conn, pstemt, rs);
		}
	}
	@Test
	public void  D(){
		
	final ArrayList<Integer> arr= new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
	
	List list =(List) Proxy.newProxyInstance(JDBCUtilsTest.class.getClassLoader(), arr.getClass().getInterfaces(), 
			new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					String name = method.getName();
					if("add".equals(name)){
						System.out.println("不能添加");
						return false;
					}
					Object invoke = method.invoke(arr, args);
					return invoke;
				}
			});
		System.out.println(list.toString());
		list.add(12);
		list.remove(0);
		System.out.println(list.toString());
		
	}
}
