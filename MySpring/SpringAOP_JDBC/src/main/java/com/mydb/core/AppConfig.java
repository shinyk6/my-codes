package com.mydb.core;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.mydb")
@EnableAspectJAutoProxy
@EnableTransactionManagement //어노테이션 기반 트랜잭션 관리를 활성화 하겠다. (1)
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/my_emp");
        ds.setUsername("uk60");
        ds.setPassword("thdbsWkd123");
        
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }
    
    @Bean //(2)
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
}
