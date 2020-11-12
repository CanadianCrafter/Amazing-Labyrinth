package employee;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	
	public SalariedEmployee(String first, String last, String ssn, Date birthDate, double salary) {
		
		super(first, last, ssn, birthDate);
		setWeeklySalary(salary);
	}
	
	public void setWeeklySalary(double salary) {
		if(salary<0) {
			weeklySalary=0;
		}else {
			weeklySalary=salary;
		}
		
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	public double earnings() {
		return getWeeklySalary();
	}
	
	public String toString() {
		
		return String.format("salaried employee: %s\n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}
}
