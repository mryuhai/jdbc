package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import utils.C3P0Utils;

public class DBUtils_v1 {
	
	
	private static final String Category = null;
	@Test
	
	public void DBUtis_v1() throws SQLException{
		/**
		 * DBUtils ���������
		 * 1��QueryRunner�� ��ȡһ��QueryRunner�� �Ǵ��ڲ���sql����API
		 * 2��ResultSetHandler �ӿڡ�	 ���ڶ���select��������ô����װ�������
		 * 3��DbUtils �ࡣ��һ���� �������˹ر���Դ��������ķ�����
		 */
		
		QueryRunner oq = new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into category values(?,?)";
		Object[] params={4,"������Ʒ"};
		
		int update = oq.update(sql, params);
		System.out.println(update);
	}
	@Test
	public void selectCategory() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *from category ";
		List<Category> list = qr.query(sql, new BeanListHandler<Category>(Category.class));
		System.out.println(list);
	}
	
	@Test
	public void MapCategory() throws SQLException{
		QueryRunner qr = new  QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select *from category ";
		
		 Map<String, Object> list = qr.query(sql, new MapHandler());
		 System.out.println(list.toString());
		
	}
	@Test
	public void st() throws SQLException{
		
		QueryRunner rs = new QueryRunner(C3P0Utils.getDataSource());
		String sql="update category set cname=? where cid=?";
	
		int j = rs.update(sql,"������Ʒ","3");
		if(j>0){
			
			System.out.println("���³ɹ�");
		}
		
	}
}
