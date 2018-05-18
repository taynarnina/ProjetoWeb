package br.edu.ufab.test.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@ComponentScan({ "br.edu.ufab" })
@Configuration
public class SpringRootConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	/*@PostConstruct
	public void startDBManager() {
		
		DriverManagerDataSource.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });

	}*/
	
	//MethodInvokingBean example
	/*
	@PostConstruct
	public void startDBM() {
		MethodInvokingBean mBean = new MethodInvokingBean();
		mBean.setTargetClass(DatabaseManagerSwing.class);
		mBean.setTargetMethod("main");
		String[] args = new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" };
		mBean.setArguments(args);
		try {
			mBean.prepare();
			mBean.invoke();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

}