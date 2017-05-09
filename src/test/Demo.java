package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import utils.C3P0Utils;

public class Demo {
	
	
//	增加数据
	public void T1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into category values(?,?)";
		Object[] pames={"c005","厨具"};
		try {
			int i = qr.update(sql, pames);
			if(i>0){
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
//	删除数据
	public void T2(){
		
		QueryRunner qr = new  QueryRunner(C3P0Utils.getDataSource());
		String sql =" delete from category where cid=?";
		
		try {
			int i = qr.update(sql, "3");
			if(i>0){
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
		}
	}
	
//	修改数据
	public void T3() throws SQLException{
	
		 QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		 
		 String sql = "update category set cid=? where cname=?";
		 Object[] pamaes={"c004","床上用品"};
		
		 int i = qr.update(sql, pamaes);
		 if(i>0){
			 System.out.println("修改成功");
		 }
	}
	
//	查找数据一条信息  使用MapHandler
	public void T1_1(){
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql= "select *from category ";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler());
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	查找数据 一条信息 使用 listHandler
	public static void main(String[] args) {
//		T2_1();
	}
	
	public static void T2_1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category ";
		try {
			 List<Category2> list = qr.query(sql, new BeanListHandler<>(Category2.class));
			 for (Category2 category2 : list) {
				System.out.println(category2.getCid()+"-->"+category2.getCname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void T3_1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *from category ";
		try {
			 List<Map<String, Object>> map = qr.query(sql, new MapListHandler());
			 for (Map<String, Object> map2 : map) {
				
				 System.out.println(map2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void T4_1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *from category ";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler());
			System.out.println(map);
		} catch (SQLException e) {
		}
	}
	
	public void T5_1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *from category ";
		try {
			List<Object[]> list = qr.query(sql, new ArrayListHandler());
			for (Object[] objects : list) {
				for (Object object : objects) {
					System.out.println(object);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void T6_1() throws SQLException{
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *from category ";
		Object[] objects = qr.query(sql, new ArrayHandler());
		for (Object object : objects) {
			
			System.out.println(object);
		}
		
	}
	@Test
	public void T6_2() {
		Long count = 0L;
        // 1.鑾峰緱QueryRunner鏍稿績瀵硅薄
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        // 2.缂栧啓SQL璇彞
        String sql = "select count(*) from category";
        // 3.鎵ц鏌ヨ鎿嶄綔
        try {
            int query = (int)qr.query(sql, new ScalarHandler());
            System.out.println(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
}
