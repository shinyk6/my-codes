package com.todo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.todo.app.mapper")
public class SpringWorkTodoApp07Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWorkTodoApp07Application.class, args);
	}

}
