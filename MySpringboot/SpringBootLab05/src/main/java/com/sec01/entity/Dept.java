package com.sec01.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor 

//Dept -> Emp -> Dept -> ...무한 루프 되는 것을 방지
//emps에 해당하는 문자열은 출력하지 말아라 -> private List<Emp> emps; 빼줘
//@ToString(exclude="emps")
public class Dept {
	
	@Id 
	private int deptno; 
	private String dname; 
	private String loc; 
	
	@OneToMany(mappedBy = "dept") 
	@ToString.Exclude
	private List<Emp> emps; 
}
