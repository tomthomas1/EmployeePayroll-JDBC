package com.bridgelabz;
import java.sql.Connection;

import configuration.Configuration;
import service.StatementDB;

/**
 * Main class where we check the connection and execute the method.
 * @author Tom
 *
 */
public class JDBC {

	public static void main(String[] args) {
		Configuration config = Configuration.getInstance();
		
		Connection connection = config.getConnection();
		
		if(connection != null) 
			System.out.println(" Connection established");
		else
			System.out.println(" Connection failed");
		
		StatementDB statement = new StatementDB(connection);
		statement.preparedUpdate();
		statement.read();
	}
}
