package com.test.mytest;

import jakarta.persistence.*;


@Entity //DB랑 매핑하겠다 - Entity로 설정
@Table(name="users")  //Table이름을 users라고 하겠다.
public class User {
	
	@Id // id를 기본키 지정하겠다 = PK
	@GeneratedValue(strategy = GenerationType.AUTO) // id 자동 증가하겠다.
	@Column // 해당 필드를 DB의 컬럼으로 명시.  속성 - name, length, nullable=true/false
	private int id;

	//@Column(name="username", length=50, nullable=false) //컬럼이 username으로 만들어짐
	@Column
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
