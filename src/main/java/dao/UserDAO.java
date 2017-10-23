package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import emp.User;
import util.YdDBUtil;

public class UserDAO {
	public User findByUsername(int card){
		User user = null;
		Connection conn = null;
		try {
			System.out.println("carddao:"+card);
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM t_vip_ymj WHERE id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, card);
			ResultSet rs = ps.executeQuery();
			System.out.println("rslength:"+rs.getRow());
			if(rs.next()){
				user = new User();
				int id = rs.getInt("id");
				user.setId(id);
				System.out.println("id:"+id);
				String username = rs.getString("username");
				user.setUsername(username);
				System.out.println("username:"+username);
				String pwd = rs.getString("password");
				user.setPassword(pwd);
				System.out.println("pwd:"+pwd);
				int money = rs.getInt("money");
				user.setMoney((double)(money));	
				System.out.println("money:"+money);
				System.out.println("user:"+user);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
		return null;
	}
	
	
	
	public String findPasswordByUsername(int card){
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "select password from t_vip_ymj where id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, card);
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
	
	
	public Double findMoneyByOrder(int card){
		
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "select money from t_vip_ymj where id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, card);
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
	
	public int updateMoney(Double money,int card){//更新余额
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "update t_vip_ymj set money=? where id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setDouble(1, money);
			ps.setInt(2, card);
			int row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
	}	
	
	public int insertIndent(int deskNo,Double money){	//保存订单信息
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "insert into yd_indent values(seq_yd_indent.nextval,?,sysDate,?,null)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, deskNo);
			ps.setDouble(2, money);
			int row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			YdDBUtil.close(conn);
		}
	}
}









