package configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * We have created this class to configure the JDBC connection
 * We are using the MYSQL driver and connection.
 * 1. Load and establish the driver
 * 2. Establish the connection
 * 
 * 
 * @author Tom
 *
 */
public class Configuration {

	
	static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
	static final String USER_NAME = "root";
	
	//To establish the connection
	static Connection connection = null;
	private static Configuration config = new Configuration();
	
	/**
	 * Method to establish the connection
	 *  We are using the connection interface and then using the Driver Manager class and get connection method to establish the connection.
	 *  We are using the MySql driver.
	 */
	private Configuration() {
		try {
			//load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, "Password@11");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static Configuration getInstance() {
		return config;
	}
}
