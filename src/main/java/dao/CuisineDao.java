package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cui;
import entity.Cuisine;
import entity.Indent;
import util.DBUtil;

public class CuisineDao {
	private Cuisine createCuisine(ResultSet rs) throws SQLException {
		Cuisine c = new Cuisine();
		c.setNo(rs.getInt("no"));
		c.setYname(rs.getString("yname"));
		c.setPrice(rs.getDouble("price"));
		c.setS(rs.getInt("s"));
		c.setM(rs.getDouble("m"));
		return c;
		
	}
	private Indent createIndent(ResultSet rs) throws SQLException {
		Indent c = new Indent();
		c.setNum1(rs.getInt("num1"));
		c.setConsumption(rs.getDate("consumption"));
		c.setMoney(rs.getDouble("money"));
		return c;
	}
	private Cui createCui(ResultSet rs) throws SQLException {
		Cui c = new Cui();
		c.setId(rs.getInt("id"));
		c.setYname(rs.getString("yname"));
		c.setPrice(rs.getDouble("price"));
		c.setNum(rs.getInt("num"));
		c.setNo(rs.getInt("no"));
		c.setPath(rs.getString("path"));
		c.setUpdate_time(rs.getDate("update_time"));
		c.setSearch(rs.getString("search"));
		return c;
	}
	public List<Cui> findPageObjects(String name,int valid,int startIndex,int pageSize){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_mwgd ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(1, pageSize);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	public int getRowCount(String name,int valid){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT count(*) FROM yd_mwgd";
			PreparedStatement ps = conn.prepareStatement(sql);
			int rows = ps.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//��ѯ����Ա������
	public String findName(int id){
		Connection conn = null;
		String name = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select yname from yd_manager where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("yname");
			}
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//��Ӳ�Ʒ
	public void saveCuisine(Cui cui){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO YD_Tables VALUES(17,?,?,?,sysdate,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cui.getYname());
			ps.setDouble(2, cui.getPrice());
			ps.setInt(3, cui.getNum());
			ps.setString(4, cui.getPath());
			ps.setInt(5, cui.getNo());
			ps.setString(6, cui.getSearch());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//ɾ����Ʒ
	public void deleteCuisine(Cui cui){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			CuisineDao dao = new CuisineDao();
			String sql = "delete from yd_tables where no =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cui.getNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败!",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//��ѯ��������
	public List<Cuisine> findAll(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from yd_sell";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//��ѯ���й���
	public List<Cui> find_MWGD(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_mwgd ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**������׼�¼������*/
	public int findRow_mwgd(){
		Connection conn = null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_mwgd";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()){
				a = rs1.getInt(1);
			}
		} catch (SQLException e) {
						e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		return a;
		
            
		
	}
	//��ѯ���о�����
	public List<Cui> find_YSJG(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_ysjg ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//��ѯ������������
	public int findRow_ysjg(){
		Connection conn = null;
		int rows = 0;
		try {
			conn =DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_ysjg";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()){
				 rows = rs1.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return rows;
		
		
	}
	
	//��ѯ��������
	public List<Cui> find_HXHY(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_hxhy where no like '5%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**��������¼������*/
	public int findRow_hxhy(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_hxhy";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	//��ѯ���о����Ʒ
	public List<Cui> find_JDCP(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_jdcp where no like '3%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**��������Ʒ���¼������*/
	public int findRow_jdcp(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_jdcp";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	//��ѯ��������Ʒ��
	public List<Cui> find_DMZP(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_dmzp where no like '6%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**���������Ʒ���¼������*/
	public int findRow_dmzp(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_dmzp";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	//��ѯ�����ز�
	public List<Cui> find_XXSC(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_xxsc where no like '8%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**��������߲����¼������*/
	public int findRow_xxsc(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_xxsc";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	/**��ѯ˳������*/
	public List<Cui> find_SHWZ(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_shwz where no like '2%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**���˳���������¼������*/
	public int findRow_shwz(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_shwz";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	/**��Ʒţ��*/
	public List<Cui> find_JPNY(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_jpny where no like '4%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**�����Ʒţ�����¼������*/
	public int findRow_jpny(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_jpny";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**���ƿ���*/
	public List<Cui> find_MJKY(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM yd_mjky where no like '9%' ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**������ƿ�Ʒ���¼������*/
	public int findRow_mjky(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from yd_mjky";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
            
	}
	/**今日菜品*/
	public List<Cuisine> day_cuisine(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM (SELECT * FROM ( "
					+ "SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M FROM YD_SELL WHERE "
					+ "(no like '2%' or no like '3%' or no like '4%' or no like '5%' or "
					+ "no like '6%' or no like '7%' or no like '8%') AND "
					+ "TO_CHAR(YD_SELL.DAY,'dd')=TO_CHAR(SYSDATE,'dd') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**今日菜品总数*/
	public int findRow_dc(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where (no like '2%' or no like '3%' or "
					+ "no like '4%' or no like '5%' or no like '6%' or no like '7%' or no like '8%') "
					+ "and TO_CHAR(yd_sell.day,'dd')=TO_CHAR(SYSDATE,'dd') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;   
	}
	/**今日酒水*/
	public List<Cuisine> day_drink(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '9%' AND TO_CHAR(YD_SELL.DAY,'dd')=TO_CHAR(SYSDATE,'dd') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**今日酒水总数*/
	public int findRow_dd(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '9%' "
					+ "and TO_CHAR(yd_sell.day,'dd')=TO_CHAR(SYSDATE,'dd') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**今日锅底*/
	public List<Cuisine> day_pot(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '1%' AND TO_CHAR(YD_SELL.DAY,'dd')=TO_CHAR(SYSDATE,'dd') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**今日锅底总数*/
	public int findRow_dp(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '1%' "
					+ "and TO_CHAR(yd_sell.day,'dd')=TO_CHAR(SYSDATE,'dd') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**本周菜品*/
	public List<Cuisine> week_cuisine(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM (SELECT * FROM ( "
					+ "SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M FROM YD_SELL WHERE "
					+ "(no like '2%' or no like '3%' or no like '4%' or no like '5%' or "
					+ "no like '6%' or no like '7%' or no like '8%') AND "
					+ "TO_CHAR(YD_SELL.DAY,'iw')=TO_CHAR(SYSDATE,'iw') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本周菜品总数*/
	public int findRow_wc(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where (no like '2%' or no like '3%' or "
					+ "no like '4%' or no like '5%' or no like '6%' or no like '7%' or no like '8%') "
					+ "and TO_CHAR(yd_sell.day,'iw')=TO_CHAR(SYSDATE,'iw') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;   
	}
	/**本周酒水*/
	public List<Cuisine> week_drink(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '9%' AND TO_CHAR(YD_SELL.DAY,'iw')=TO_CHAR(SYSDATE,'iw') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本周酒水总数*/
	public int findRow_wd(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '9%' "
					+ "and TO_CHAR(yd_sell.day,'iw')=TO_CHAR(SYSDATE,'iw') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**本周锅底*/
	public List<Cuisine> week_pot(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '1%' AND TO_CHAR(YD_SELL.DAY,'iw')=TO_CHAR(SYSDATE,'iw') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本周锅底总数*/
	public int findRow_wp(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '1%' "
					+ "and TO_CHAR(yd_sell.day,'iw')=TO_CHAR(SYSDATE,'iw') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**今月菜品*/
	public List<Cuisine> month_cuisine(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM (SELECT * FROM ( "
					+ "SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M FROM YD_SELL WHERE "
					+ "(no like '2%' or no like '3%' or no like '4%' or no like '5%' or "
					+ "no like '6%' or no like '7%' or no like '8%') AND "
					+ "TO_CHAR(YD_SELL.DAY,'mm')=TO_CHAR(SYSDATE,'mm') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本月菜品总数*/
	public int findRow_mc(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where (no like '2%' or no like '3%' or "
					+ "no like '4%' or no like '5%' or no like '6%' or no like '7%' or no like '8%') "
					+ "and TO_CHAR(yd_sell.day,'mm')=TO_CHAR(SYSDATE,'mm') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;   
	}
	/**本月酒水*/
	public List<Cuisine> month_drink(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '9%' AND TO_CHAR(YD_SELL.DAY,'mm')=TO_CHAR(SYSDATE,'mm') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本月酒水总数*/
	public int findRow_md(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '9%' "
					+ "and TO_CHAR(yd_sell.day,'mm')=TO_CHAR(SYSDATE,'mm') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**本月锅底*/
	public List<Cuisine> month_pot(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) S,SUM(MONEY) M "
					+ "FROM YD_SELL WHERE NO LIKE '1%' AND TO_CHAR(YD_SELL.DAY,'mm')=TO_CHAR(SYSDATE,'mm') "
					+ "GROUP BY YNAME,PRICE,NO ORDER BY S DESC ) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本月锅底总数*/
	public int findRow_mp(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from (select no,yname,price,sum(sums) s,"
					+ "sum(money) m from yd_sell where no like '1%' "
					+ "and TO_CHAR(yd_sell.day,'mm')=TO_CHAR(SYSDATE,'mm') group by yname,price,no "
					+ "order by s desc)";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**今日订单*/
	public List<Indent> di(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT num1,consumption,money FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ("
					+ "SELECT * FROM YD_INDENT "
					+ "WHERE TO_CHAR(CONSUMPTION,'dd')=TO_CHAR(SYSDATE,'dd'))"
					+ "ORDER BY num1) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Indent> list = new ArrayList<Indent>();
			while(rs.next()){
				Indent c = createIndent(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**今日订单总数*/
	public int findRow_di(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select num1,consumption,money from yd_indent "
					+ "where TO_CHAR(consumption,'dd')=TO_CHAR(SYSDATE,'dd'))";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**本周订单*/
	public List<Indent> wi(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT num1,consumption,money FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ("
					+ "SELECT * FROM YD_INDENT "
					+ "WHERE TO_CHAR(CONSUMPTION,'iw')=TO_CHAR(SYSDATE,'iw'))"
					+ "ORDER BY num1) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Indent> list = new ArrayList<Indent>();
			while(rs.next()){
				Indent c = createIndent(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本周订单总数*/
	public int findRow_wi(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select num1,consumption,money from yd_indent "
					+ "where TO_CHAR(consumption,'iw')=TO_CHAR(SYSDATE,'iw'))";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**本月订单*/
	public List<Indent> mi(Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT num1,consumption,money FROM ("
					+ "SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ("
					+ "SELECT * FROM YD_INDENT "
					+ "WHERE TO_CHAR(CONSUMPTION,'mm')=TO_CHAR(SYSDATE,'mm'))"
					+ "ORDER BY num1) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Indent> list = new ArrayList<Indent>();
			while(rs.next()){
				Indent c = createIndent(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**本月订单总数*/
	public int findRow_mi(){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select num1,consumption,money from yd_indent "
					+ "where TO_CHAR(consumption,'mm')=TO_CHAR(SYSDATE,'mm'))";
			PreparedStatement ps1 = conn.prepareStatement(sqlPage);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) a=rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	//ģ����ѯ����
	public List<Cuisine> vague(String name){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from yd_sell where yname like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) { 
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**模糊查询销量*/
	public List<Cuisine> ss(String name,Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM ( SELECT NO,YNAME,PRICE,SUM(SUMS) "
					+ "S,SUM(MONEY) M FROM YD_SELL WHERE YNAME LIKE ? "
					+ "GROUP BY YNAME,NO,PRICE ORDER BY S DESC) ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = createCuisine(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**模糊查询销量总数*/
	public int findRow_ss(String name){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select * from yd_sell where yname like ?)";
			PreparedStatement ps = conn.prepareStatement(sqlPage);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) a=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**模糊查询菜品*/
	public List<Cui> sc(String name,Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM ("
					+ "SELECT ROWNUM RN,T.* FROM (SELECT * FROM ("
					+ "select * from yd_tables where yname like ?)"
					+ "ORDER BY NO ) T)"
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**模糊查询菜品总数*/
	public int findRow_sc(String name){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select * from yd_tables where yname like ?)";
			PreparedStatement ps = conn.prepareStatement(sqlPage);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) a=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**模糊查询订单*/
	public List<Indent> si(Integer no,Integer startIndex,Integer endIndex){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT num1,consumption,money FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM (select * from yd_indent where num1 = ?) "
					+ "ORDER BY NUM1 ) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setInt(2, startIndex);
			ps.setInt(3, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Indent> list = new ArrayList<Indent>();
			while(rs.next()){
				Indent c = createIndent(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**模糊查询订单总数*/
	public int findRow_si(Integer no){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select * from yd_indent where num1= ?)";
			PreparedStatement ps = conn.prepareStatement(sqlPage);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) a=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
	/**查询选中*/
	public List<Cui> update(String nos,Integer startIndex,Integer endIndex){
		Connection conn = null;
		String[] no = nos.split(",");
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RN,T.* FROM ("
					+ "SELECT * FROM (select * from yd_tables where no in ("+nos+")) "
					+ "ORDER BY no) T) "
					+ "WHERE RN BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1,nos);
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			ResultSet rs = ps.executeQuery();
			List<Cui> list = new ArrayList<Cui>();
			while(rs.next()){
				Cui c = createCui(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询销量失败",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	/**查询选中总数*/
	public int findRow_update(String nos){
		Connection conn =null;
		int a=0;
		try {
			conn = DBUtil.getConnection();
			String sqlPage = "select count(*) from ("
					+ "select * from yd_tables where no in ("+nos+"))";
			PreparedStatement ps = conn.prepareStatement(sqlPage);
			//ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) a=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return a;
	}
}
