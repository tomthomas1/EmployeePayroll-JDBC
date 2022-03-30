package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.EmployeeDB;
import entity.EmployeePayroll;

/**
 * In this class we are writing the statement 
 * @author Tom
 *
 */
public class StatementDB {

	final static String query = "SELECT * from employee_payroll";
	final static String UPDATE_DB = "UPDATE employee_payroll SET Salary = 3000000 WHERE name = 'Terissa'";
	final static String preparedQuery = "UPDATE employee_payroll SET Salary = ? WHERE name = ?";
	Connection connection;
	ArrayList<EmployeePayroll> db;

	public StatementDB(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}

	/**
	 * Method to read the database and display in console.
	 * 1. We create a connection and then create a statement and store the result in ResultSet.
	 * We use while next to iterate through the database.
	 * We are also adding this to the ArrayList
	 */
	public void read() {

		db = EmployeeDB.getEmployeeDB();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				EmployeePayroll e = new EmployeePayroll(result.getInt(1), result.getString(2),result.getDouble(3), result.getString(4),
						result.getString(5), result.getInt(6), result.getString(7), result.getString(8),
						 result.getDouble(9), result.getDouble(10), result.getDouble(11),
						result.getDouble(12), result.getDouble(13));
				db.add(e);
				System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Method to update the database with normal statement 
	 * @return - true if updated
	 */
	public boolean update() {

		ArrayList<EmployeePayroll> db = EmployeeDB.getEmployeeDB();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.execute(UPDATE_DB);

			for (EmployeePayroll employeePayroll : db) {
				if (employeePayroll.getName().equals("Terissa")) {
					employeePayroll.setSalary(3000000);
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * Method to update the database with prepared statement.
	 * @return - true if updated
	 */
	public boolean preparedUpdate() {

		ArrayList<EmployeePayroll> db = EmployeeDB.getEmployeeDB();
		PreparedStatement pStatement = null;

		try {
			pStatement = connection.prepareStatement(preparedQuery);
			pStatement.setInt(1, 50000);
			pStatement.setString(2, "Terissa");
			pStatement.execute();

			for (EmployeePayroll employeePayroll : db) {
				if (employeePayroll.getName().equals("Terissa")) {
					employeePayroll.setSalary(50000);
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
