package entity;
import java.util.ArrayList;
/**
 * ArrayList for the employee database
 * @author Tom
 *
 */
public class EmployeeDB {

	static ArrayList<EmployeePayroll> employeeDB = new ArrayList<EmployeePayroll>();
	
	public static ArrayList<EmployeePayroll> getEmployeeDB() {
		return employeeDB;
	}
}