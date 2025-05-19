package workshop.work07;

public class Secreraty extends Employee implements Bonus {

	public Secreraty() {
		// TODO Auto-generated constructor stub
	}

	public Secreraty(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void incentive(int pay) {
		// TODO Auto-generated method stub
		this.setSalary((int)(this.getSalary()+this.getSalary()+(pay*0.8)));
	}

	@Override
	double tax() {
		// TODO Auto-generated method stub
		return this.getSalary()*0.1;
	}
	
	

}
