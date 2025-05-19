package workshop.work09;
//9-2
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import static java.util.Comparator.comparingInt; //static method import 는 메소드만 바로 호출하면 됨 

class Student {
	private String name;
	private int age;
	private int height;
	private int weight;

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	//혹은 toString오버라이드 해서 사용
	public String studentInfo() {
		return
		String.format("%10s %5d %5d %5d \n", this.getName(), this.getAge(), this.getHeight(),this.getWeight());
	}
}

public class StudentTest {
	public static void main(String[] args) { //혹은 new ArrayList<>(); students.add(new Student()) 사용해도 됨
		List<Student> students = Arrays.asList(new Student("홍길동", 15, 170, 80), new Student("한사람", 13, 180, 70),
				new Student("이순신", 16, 175, 65));

		System.out.println("이름\t나이\t신장\t몸무게");

		for (Student student : students) {
			System.out.println(student.studentInfo());
		}

		////////////////////////////////////////////////////////
		
		OptionalDouble averageAge = students.stream().mapToInt(Student::getAge).average(); //int값이기에 mapToInt에 넣음
		OptionalDouble averageHeight = students.stream().mapToInt(Student::getHeight).average();
		OptionalDouble averageWeight = students.stream().mapToInt(Student::getWeight).average();

		System.out.printf("\n\n나이 평균: %.3f\n", averageAge.orElse(0));
		System.out.printf("신장 평균: %.3f\n", averageHeight.orElse(0));
		System.out.printf("몸무게 평균: %.3f\n", averageWeight.orElse(0));

		//////////////////////////////////////////////////////// 
		Student youngestStudent = students.stream().min(comparingInt(Student::getAge)).orElse(null); //comparingInt->import satatic method 메소드명 바로 호출
		Student oldestStudent = students.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
				.orElse(null);

		System.out.println("\n\n나이가 가장 많은 학생: " + oldestStudent.getName());
		System.out.println("나이가 가장 적은 학생: " + youngestStudent.getName());

		//////////////////////////////////////////////////////////////////
		Student shortestStudent = students.stream().min(comparingInt(Student::getHeight)).orElse(null);
		Student tallestStudent = students.stream().max(comparingInt(Student::getHeight)).orElse(null);

		System.out.println("신장이 가장 큰 학생: " + tallestStudent.getName());
		System.out.println("신장이 가장 작은 학생: " + shortestStudent.getName());

		//////////////////////////////////////////////////////////////////
		Student lightestStudent = students.stream().min(comparingInt(Student::getWeight)).orElse(null);
		Student heaviestStudent = students.stream().max(comparingInt(Student::getWeight)).orElse(null);

		System.out.println("몸무게가 가장 많이 나가는 학생: " + heaviestStudent.getName());
		System.out.println("몸무게가 가장 적게 나가는 학생: " + lightestStudent.getName());
	}
}
