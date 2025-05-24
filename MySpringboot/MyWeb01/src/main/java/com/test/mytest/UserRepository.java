package com.test.mytest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	//save(), findById(), findAll(), delete() 등 = crud 
	
}
