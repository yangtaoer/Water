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
	
	public List<YdEmp> findByName(String sname) {
		Connection conn = null;
		List<YdEmp> list = new LinkedList<YdEmp>();
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM yd_tables where search like ? ";
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
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			YdDBUtil.close(conn);
		}

	}
}
