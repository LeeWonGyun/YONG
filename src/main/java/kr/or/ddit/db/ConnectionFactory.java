package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * Factory Object[Method] Pattern
 * : consumer 에 의해 소비되는 객체 생성만을 전담하는 객체 운영.
 *
 */
public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo", Locale.ENGLISH);
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		int initalSize = Integer.parseInt(bundle.getString("initalSize"));
		long maxWait = Long.parseLong(bundle.getString("maxWait"));
		int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
		BasicDataSource ds = new BasicDataSource();
		dataSource = ds;
		ds.setDriverClassName(bundle.getString("driverClassName"));
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(3); //3개 생성
		ds.setMaxWaitMillis(2000);
		ds.setMaxTotal(5); //3개를 만들고 4개째에 2초 기다렸는데 반납이 없으면 하나 만들고 해서 총 5개. 5개 넘어가면 sqlexception
		
		
		
//		ds.setInitialSize(50); //50개를 만들어놓겠다., 50개정도 만들어 놓으면 어지간한 스레드들 다 처리할 수 있다
//		OracleConnectionPoolDataSource ds;
//		try {
//			ds = new OracleConnectionPoolDataSource();
//			dataSource = ds;
//			ds.setURL(url);
//			ds.setUser(user);
//			ds.setPassword(password);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		try {
//			Class.forName(bundle.getString("driverClassName"));
//			System.out.println(message);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
	}
	
	public static Connection getConnection() throws SQLException{
//	 	3. Connection 생성
//		return DriverManager.getConnection(url, user, password);
		return dataSource.getConnection();
	}
}
