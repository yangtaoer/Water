package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import emp.YdEmp;
import util.YdDBUtil;

public class YdDAO {
	/**
	 * 1.通过表名查找所有菜品
	 */
	public List<YdEmp> findByTableName(String tName) {
		Connection conn = null;
		List<YdEmp> list = new LinkedList<YdEmp>();
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM  "+ tName;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				YdEmp ye = new YdEmp(   rs.getString("yname"), 
										rs.getInt("price"),  
										rs.getInt("num"),
										rs.getDate("update_time"), 
										rs.getString("path"), 
										rs.getInt("no"),
										rs.getString("search") 
										);				
				list.add(ye);				
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			YdDBUtil.close(conn);
		}
		
	}
	
	/**
	 * 
	 * @param sname   查询条件like后面的东西
	 * @param condition   根据输入的是中文还是英文判断是根据菜品名搜索还是根据拼音缩写
	 * @return
	 */
	public List<YdEmp> findByName(String sname,String condition) {
		
		Connection conn = null;
		List<YdEmp> list = new LinkedList<YdEmp>();
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM yd_tables where "+condition+" like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+sname+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				YdEmp ye = new YdEmp(   rs.getString("yname"), 
										rs.getInt("price"),  
										rs.getInt("num"),
										rs.getDate("update_time"), 
										rs.getString("path"), 
										rs.getInt("no"),
										rs.getString("search") 
										);				
				list.add(ye);				
			}
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			YdDBUtil.close(conn);
		}

	}
	
	
	
}
