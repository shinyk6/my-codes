package com.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jdbc.core.JdbcTemplate; //common/JdbcTemplate 대신 core 사용
import org.springframework.jdbc.datasource.DriverManagerDataSource; //DB연결 속성 정보를 가진 객체(setUser, setPassword등..)

import javax.sql.*; //DataSource 사용하기 위해

@Configuration //환경설정 파일 이라는 뜻
@ComponentScan(basePackages = "com.person") //패키지 하위 전부 스캔
@PropertySource("classpath:db.properties") //src바로 아래
public class AppConfig {
	
	
	@Bean
	public DataSource dataSource(org.springframework.core.env.Environment env) {//선조인 DataSoruce인터페이스의 메소드를 사용
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
	
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) { //자기자신을 리턴해서 사용
		return new JdbcTemplate(dataSource);
	}

}
