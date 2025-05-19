package com.student.controller;

import com.student.service.*;
import com.student.model.*;
import com.student.view.*;
import java.util.Scanner;

public class StudentController {
	
	private final StudentService service = new StudentServiceImpl();
	private final StudentConsolView view = new StudentConsolView();
	private final Scanner sc = new Scanner(System.in);
	
	
	public void run() {
		//메뉴 생성 = 페이지 이동
		while(true) {
			System.out.println("1. 전체 출력 | 2. 추가 | 3. 삭제 | 4. 수정 | 0. 종료");
			String menu = sc.nextLine(); // Enter를 치기전까지 쓴 문자열을 모두 리턴
			switch(menu) {
			case "1" : //select - 서비스 컴포넌트가 받은 dao의 결과를 view에게 전달
				view.showAllList(service.selectAllStudent());
				break;
			case "2" : //insert
				//1. input으로 view에서 데이터 입력
				System.out.printf("학생 이름 : ");
				String name = sc.nextLine();
				System.out.printf("전공 : ");
				String major = sc.nextLine();
				System.out.printf("성적 : ");
				int grade = Integer.parseInt(sc.nextLine());
				
				//2. Student 담아서 넘기기 : Person객체 생성해서 데이터 저장
				Student s = new Student(name, major, grade);
				
				//3. Student 객체 값을 service(dao)에 전달
				int res = service.insertStudent(s);
				view.showMessage(res>0? "등록 성공" : "등록 실패");
				break;
				
			case "3" : //delete
				//1. input으로 view에서 데이터 입력
				System.out.println("학생 ID : ");
				int delete_id = Integer.parseInt(sc.nextLine());
				
				//2. Student 담아서 넘기기 : Person객체 생성해서 데이터 저장
				Student s0 = new Student();
				s0.setId(delete_id);
				
				//3. Student 객체 값을 service(dao)에 전달
				//실행 + 조건 분기 + 출력까지 한 줄에 다 처리하는 구문
				//한 줄에 너무 많은 로직을 담으면 디버깅 어려움, 테스트 불편함, 가독성 저하 등의 문제점이 발생할 수 있음
				view.showMessage(service.deleteStudent(s0)>0? "삭제 성공" : "삭제 실패"); 
				break;
				
			case "4" : //update
				//1. input view에서 데이터 입력
				System.out.print("학생 ID : ");
				int uId = Integer.parseInt(sc.nextLine());
				System.out.print("수정 할 전공 : ");
				String uMajor = sc.nextLine();
				System.out.print("수정 할 성적 : ");
				int uGrade = Integer.parseInt(sc.nextLine());
				
				//2. Student 담아서 넘기기 : Person객체 생성해서 데이터 저장
				Student s02 = new Student();
				s02.setId(uId);
				s02.setMajor(uMajor);
				s02.setGrade(uGrade);
				
				//3. Student 객체 값을 service(dao)에 전달
				int res02 = service.updateStudent(s02);
				view.showMessage(res02>0? "수정 성공" : "수정 실패");
				break;
				
			case "0" : // return으로 프로그램 종료
				System.out.println("종료합니다.");
				return;
			default : // 그 외 값이 들어올 경우 메세지 출력
				view.showMessage("잘못된 입력");
			}
			
			
		}
	}
	
}
