package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import emp.User;
import util.YdDBUtil;

public class UserDAO {
	public User findByUsername(String username){
		User user = null;
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM t_vip_ymj "
					+ "WHERE username = ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString(username));
				user.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
		return user;
	}
	
	
	
	public String findPasswordByUsername(String username){
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "select password from t_vip_ymj where username=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("password");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
		return null;
	}
	
	
	public Double findMoneyByOrder(String username){
		
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "select money from yd_indent where username=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getDouble("money");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
		return null;
	}

	
	
}









