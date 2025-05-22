package com.workshop01.test02;

import java.util.List;
import java.util.Map;

public class EmployeeService {
    private   Map<String, List<Employee>> departmentMap;

    public void setDepartmentMap(Map<String, List<Employee>> departmentMap) {
        this.departmentMap = departmentMap;
    }

    public void printAllEmployees() {
        for (String dept : departmentMap.keySet()) { // keySet을 사용. 수업시간엔 entry사용 
            System.out.println("[" + dept + " 부서]");
            for (Employee emp : departmentMap.get(dept)) {
                System.out.println("- " + emp.toString());
            }
            System.out.println();
        }
    }
}
