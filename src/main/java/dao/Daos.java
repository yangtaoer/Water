package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Cui;
import util.DBUtil;

public class Daos {
	private static final int PageSize=6;
	public static List<Cui> findinit(String nos){
		Connection c=null;
		List<Cui> list=new ArrayList<Cui>();
		try {
			c=DBUtil.getConnection();
			String sql="select * from (select RowNum t, tw.* from "
					+"( select * from yd_tables  order by no) tw )  where no in ("+nos+") ";
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt(2);
				String yname=rs.getString(3);
				double price=rs.getDouble(4);
				int num=rs.getInt(5);
				Date update_time=rs.getDate(6);
				String path=rs.getString(7);
				int no=rs.getInt(8);
				String search=rs.getString(9);
				Cui f=new Cui();
				f.setId(id);
				f.setNo(no);
				f.setNum(num);
				f.setPath(path);
				f.setPrice(price);
				f.setUpdate_time(update_time);
				f.setYname(yname);
				f.setSearch(search);
				list.add(f);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
	}
	
	//鎬荤殑璁板綍鏁伴噺,璁＄畻鍑哄熬椤电殑page鏄ソ澶�  
	public static Integer sum(String str){
		Connection c=null;
		int sum=0;
		try {
			String s="'%"+str+"%'";
			c=DBUtil.getConnection();
			String sql="select count(*) from  yd_tables where search like "+s;
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				sum=rs.getInt(1);
			}
			return sum;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
	}
	//鎼滅储鏌ヨ鎸夐〉闈㈡樉绀�
	public static List<Cui> findPageCui(String str,Integer page){
		Connection c=null;
		List<Cui> list=new ArrayList<Cui>();
		try {
			c=DBUtil.getConnection();
			String sql="select * from yd_tables ";
			sql="select * from (select RowNum t, tw.* from "
					+ "( select * from yd_tables where search like '%"+str+"%'order by id) tw )  where t between ? and ? ";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, (page-1)*PageSize+1);
			ps.setInt(2, page*PageSize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(2);
				String yname=rs.getString(3);
				double price=rs.getDouble(4);
				int num=rs.getInt(5);
				Date update_time=rs.getDate(6);
				String path=rs.getString(7);
				int no=rs.getInt(8);
				String search=rs.getString(9);
				Cui f=new Cui();
				f.setId(id);
				f.setNo(no);
				f.setNum(num);
				f.setPath(path);
				f.setPrice(price);
				f.setUpdate_time(update_time);
				f.setYname(yname);
				f.setSearch(search);
				list.add(f);
			}

			return list;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
	}
	
	//	閫氳繃no鎵捐彍鍝� 
	public static Cui fingByNo(int no){
		Connection c=null;
		try {
			c=DBUtil.getConnection();
			String sql="select * from yd_tables where no="+no ;
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String yname=rs.getString(2);
				double price=rs.getDouble(3);
				int num=rs.getInt(4);
				Date update_time=rs.getDate(5);
				String path=rs.getString(6);
				String search=rs.getString(8);
				Cui f=new Cui();
				f.setId(id);
				f.setNo(no);
				f.setNum(num);
				f.setPath(path);
				f.setPrice(price);
				f.setUpdate_time(update_time);
				f.setYname(yname);
				f.setSearch(search);
				return f;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
		return null;
	}
	public static  void update(String noss,String params,String value){
		Connection c=null;
		String[] nos=noss.split(",");
		try {
			c=DBUtil.getConnection();
			for(int i=0;i<nos.length;i++){
				int no=Integer.valueOf(nos[i]);
				Cui ci=fingByNo(no);
				String sql="update yd_tables set "+params+"=? where no="+no;
				PreparedStatement ps=c.prepareStatement(sql);
				if("price".equals(params)){
					ps.setDouble(1, ci.getPrice()*Double.valueOf(value));
					ps.executeUpdate();
				}
				if("num".equals(params)){
					ps.setInt(1, Integer.valueOf(value));	
					ps.executeUpdate();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
	}
	/**鏇存柊瀵瑰簲鐨勫瓙琛ㄦ暟鎹�*/
	public static  void update2(Cui cNew){
		Connection c=null;
		try {
			c=DBUtil.getConnection();
			int no=cNew.getNo();
			String noStr=String.valueOf(no);
			String sql="";
			if(noStr.startsWith("1")){
				sql="update yd_mwgd set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("2")){
				sql="update yd_shwz set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("3")){
				sql="update yd_jdcp set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("4")){
				sql="update yd_jpny set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("5")){
				sql="update yd_hxhy set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("6")){
				sql="update yd_dmzp set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("7")){
				sql="update yd_ysjg set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("8")){
				sql="update yd_xxsc set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			if(noStr.startsWith("9")){
				sql="update yd_mjky set yname=?,price=?,num=?,update_time=?,path=?,search=? where no="+no;
			}
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, cNew.getYname());
			ps.setDouble(2, cNew.getPrice());
			ps.setInt(3, cNew.getNum());
			ps.setDate(4, (java.sql.Date) cNew.getUpdate_time());
			ps.setString(5, cNew.getPath());
			ps.setString(6, cNew.getSearch());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(c);
		}
	}
	
}
