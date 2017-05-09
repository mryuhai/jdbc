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
		 * DBUtils 三大核心类
		 * 1：QueryRunner类 获取一个QueryRunner类 是存在操作sql语句的API
		 * 2：ResultSetHandler 接口。	 用于定义select操作后怎么样封装结果集。
		 * 3：DbUtils 类。是一个类 。定义了关闭资源和事务处理的方法。
		 */
		
		QueryRunner oq = new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into category values(?,?)";
		Object[] params={4,"床上用品"};
		
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
	
		int j = rs.update(sql,"生活用品","3");
		if(j>0){
			
			System.out.println("更新成功");
		}
		
	}
}
