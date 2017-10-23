package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.YdManager;
import emp.YdUse;
import util.YdDBUtil;

public class Dao {
	public YdUse FindUser(String name){
		Connection conn = null;
		YdUse yd = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM yd_user WHERE d_num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			    yd = new YdUse();
				yd.setD_num(rs.getInt("D_NUM"));
				yd.setId(rs.getInt("ID"));
				yd.setPsd(rs.getString("PASSWORD"));
				yd.setState(rs.getString("STATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			YdDBUtil.close(conn);
		}
		return yd;
	}
	public YdManager FindManager(String name){
		Connection conn = null;
		YdManager yd =null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "SELECT * FROM yd_manager WHERE yname =?";		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				yd = new YdManager();
				yd.setGender(rs.getString("gender"));
				yd.setId(rs.getInt("ID"));
				yd.setPsd(rs.getString("PSD"));
				yd.setYname(rs.getString("YNAME"));
			}
       } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!");
		}finally{
			YdDBUtil.close(conn);
		}
		return yd;
	}

}
