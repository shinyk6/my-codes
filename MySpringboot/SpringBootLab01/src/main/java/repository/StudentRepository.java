package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab01.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{ //Long인 이유 - 자동증가 pk로 crud작업하기에
	//후손 클래스가 어떤 형태로 crud할지 모르니까 추상으로 구현
	
	//추가 코드 선언 가능!!

}
