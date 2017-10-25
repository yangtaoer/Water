package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import emp.SellObject;
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
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			YdDBUtil.close(conn);
		}

	}
	
	public int saveObjects(SellObject so) {//保存销售记录
		Connection conn = null;
		try {
			conn = YdDBUtil.getConnection();
			String sql = "insert into yd_sell values(seq_yd_sell.nextval,?,?,?,?,sysdate,?,?,?)";
							//insert into yd_sell values(seq_yd_sell.nextval,'精品肥牛',25,10,250,sysdate,10,405,'sss');
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, so.getYname());
			ps.setInt(2, (int)so.getPrice());
			ps.setInt(3, so.getSums());
			ps.setInt(4, (int)so.getMoney());
			ps.setInt(5,so.getMoth());
			ps.setInt(6,so.getNo());
			ps.setString(7, so.getPath());
			int rows = ps.executeUpdate();
			return rows;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			YdDBUtil.close(conn);
		}	
		return 0;
	}
	
	/*public List<SellObject> rank() {
		Connection conn = null;
		List<SellObject> list = new LinkedList<SellObject>();
		try {
			conn = YdDBUtil.getConnection();
			String sql =" select distinct YD_SELL.NO,YD_SELL.YNAME,YD_SELL.PRICE,YD_SELL.MONEY,yd_sell.path,a.count sums from"+
					" (SELECT YNAME,COUNT(YNAME) count FROM YD_SELL GROUP BY YNAME) a left join yd_sell "+ 
					" on a.yname=yd_sell.yname where TO_CHAR(yd_sell.day,'dd')=TO_CHAR(SYSDATE,'dd') order by a.count desc ";//查询前一天的数据			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()) {
				SellObject so = new SellObject(0,
												rs.getString("yname"),
												rs.getDouble("price"),
												rs.getInt("sums"),
												rs.getDouble("money"),
												new Date(System.currentTimeMillis()),
												Calendar.getInstance().get(Calendar.MONTH),
												rs.getInt("no"),
												rs.getString("path"));				
				list.add(so);				
			}
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			YdDBUtil.close(conn);
		}
	}*/
	
	public List<SellObject> rank() {
		Connection conn = null;
		List<SellObject> list = new LinkedList<SellObject>();
		try {
			conn = YdDBUtil.getConnection();
			String sql ="select * from yd_sell where trunc(day)=trunc(sysdate-1) ";//查询前一天的数据			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()) {
				SellObject so = new SellObject(0,
												rs.getString("yname"),
												rs.getDouble("price"),
												rs.getInt("sums"),
												rs.getDouble("money"),
												new Date(System.currentTimeMillis()),
												Calendar.getInstance().get(Calendar.MONTH),
												rs.getInt("no"),
												rs.getString("path"));				
				list.add(so);				
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
