package test;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import configuration.Configuration;
import service.StatementDB;

/**
 * To check the test cases.
 * @author Tom
 *
 */
public class TestJDBC {
	
	Connection connection;
	Configuration config;
	StatementDB statement;
	
	@Before
	public void initialization() {
		config = Configuration.getInstance();
		connection = config.getConnection();
		statement = new StatementDB(connection);
	}

	/**
	 * To test if the update is successful.
	 */
	@Test
	public void testUpdateHappy() {
		statement.read();
		statement.update();
		
		assertEquals(statement.update(), true);
	}
}
