package in.inueron.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class jdbcUtil {

	private jdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		
		HikariConfig config=new HikariConfig("E:\\Eclipse _Workspace2\\JDBC CRUD App\\src\\in\\inueron\\properties\\db.properties");
		
		@SuppressWarnings("resource")
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
	}

}

