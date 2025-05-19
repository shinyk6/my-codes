package com.mysqlapp.view;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;
import com.mysqlapp.model.EmpSalGradeDTO;

import java.util.List;

public class EmpView {
	
	// 전체 출력
    public void display(List<Emp> list) {
        System.out.println("\n=== 사원 목록 ===");
        for (Emp e : list) {
            System.out.printf("사번: %d | 이름: %s | 직무: %s | 급여: %.2f | 부서번호: %d%n",
                e.empno(), e.ename(), e.job(), e.sal(), e.deptno());
        }
    }
    
    //조인 결과
    public void printEmpWithDept(List<EmpDeptDTO> list) {
        System.out.println("\n=== 사원 + 부서 조인 목록 ===");
        for (EmpDeptDTO e : list) {
            System.out.printf("사원명: %s | 부서번호: %d | 부서명: %s | 위치: %s%n",
                e.ename(), e.deptno(), e.dname(), e.loc());
        }
    }
    
    //Eq - Join 결과
    public void printEmpWithSalGrade(List<EmpSalGradeDTO> list) {
        System.out.println("\n=== 사원 + 이름과 월급, 등급 ===");
        for (EmpSalGradeDTO e : list) {
            System.out.printf("사원명: %s | 월급: %5.1f | 등급: %d \n",
                e.ename(), e.sal(), e.grade());
        }
    }   
}
