package com.lab10.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("emp") 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
public class Emp {
	@Id 
    private Integer empno;  //_id를 empno로 매핑    
    private String ename;     
    private String job;          
    private Integer sal;          
    private Integer dept;         
}
