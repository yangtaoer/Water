package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class YdDBUtil {
	private static BasicDataSource bs;
	static {
		Properties p = new Properties();
		try {
			p.load(YdDBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			int init = Integer.parseInt(p.getProperty("init_size"));
			int max = Integer.parseInt(p.getProperty("max_size"));
			bs = new BasicDataSource();
			bs.setDriverClassName(driver);
			bs.setUrl(url);
			bs.setUsername(user);
			bs.setPassword(pwd);
			bs.setInitialSize(init);
			bs.setMaxActive(max);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取db文件失败!",e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
			return bs.getConnection();		
	}
	
	public static void close(Connection conn) {
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
				throw new RuntimeException("关闭连接失败!",e);
			}
		}
	}
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("回滚事务失败!",e);
			}
		}
		
	}
	
	
}
