package com.mydb.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class EmpService {
    private final EmpDao empDao;

    @Autowired
    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
        System.out.println("EmpService's constructor");
    }

    public List<Emp> getAll() {
        return empDao.findAll();
    }
    
    public void insertEmpwithFail(Emp emp) {
    	empDao.insert(emp); //이 명령이 롤백됨
    	if(true) {
    		throw new RuntimeException("강제 예외 발생!!");
    	}
    }
}
