package entity;

/**
 * In this class we have defined the variables and constructor.
 * @author Tom
 *
 */
public class EmployeePayroll {

	int id;
	String name;
	String startDate;
	String gender;
	int phone;
	String address;
	String department;
	double salary;
	double basicPay;
	double deductions;
	double taxablePay;
	double incomeTax;
	double netPay;

	public EmployeePayroll(int id, String name, double salary,  String startDate, String gender, int phone, String address,
			String department, double basicPay, double deductions, double taxablePay, double incomeTax,
			double netPay) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.department = department;
		this.salary = salary;
		this.basicPay = basicPay;
		this.deductions = deductions;
		this.taxablePay = taxablePay;
		this.incomeTax = incomeTax;
		this.netPay = netPay;
	}

	@Override
	public String toString() {
		return "EmployeePayroll [id=" + id + ", name=" + name + ", startDate=" + startDate + ", gender=" + gender
				+ ", phone=" + phone + ", address=" + address + ", department=" + department + ", salary=" + salary
				+ ", basicPay=" + basicPay + ", deductions=" + deductions + ", taxablePay=" + taxablePay
				+ ", incomeTax=" + incomeTax + ", netPay=" + netPay + "]";
	}

}
