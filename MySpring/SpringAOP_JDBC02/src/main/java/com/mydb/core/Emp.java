package com.mydb.core;
import lombok.*;

@Data //data를 자동으로 만들어줌 
@NoArgsConstructor //기본 생성자를 만드는 어노테이션
@AllArgsConstructor //매개변수가 있는 생성자를 만들어줌 (필드 생성자)
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int deptno;
}
