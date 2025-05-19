package workshop.work07;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		//
		Employee emp = new Sales("Hilery", 1,"secretary", 800);
		Employee emp2 = new Sales("Clinten", 2,"sales", 1200);
		

		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

		//생성한 객체를 hashMap에 넣음 
		map.put(emp.getNumber(), emp);
		map.put(emp2.getNumber(), emp2);
		
		System.out.println("%");
		
		for(int i =1; i<=map.size(); i++) {
			System.out.println(map.get(emp.getNumber()));
		}
		
		
		for (Employee e : map.values()) {
            System.out.println(e);
        }
		
		
		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            Employee emp = entry.getValue();
            if (emp instanceof Secretary) {
                Secretary sec = (Secretary)emp;
                System.out.println("name: " + sec.getName() +" department: "+sec.getDepartment()+" salary: "+sec.getSalary());
            } else {
                Sales sec = (Sales)emp;
                System.out.println("name: " + sec.getName() +" department: "+sec.getDepartment()+" salary: "+sec.getSalary());
            }
        }
	}

}
