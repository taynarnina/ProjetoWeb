package br.edu.ufab.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Classe responsável pelas configurações com o banco de dados.
 * 
 * @author Murilo Gustavo e Taynar Sousa 
 * 
 * Sprint3-18/05/2018
 * */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("br.edu.ufab.model.repositories")
public class ConfigDB {
	/**
	 * método responsável por pegar os endereços do nosso banco de dados
	 * @param
	 * 
	 * */
	
	@Bean
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/biblioteca");
		dataSource.setUser("root");
		dataSource.setPassword("");
		return dataSource;
	}
	/**
	 * método que vai criar um container local para fazermos o gerenciamento do nosso banco de dados
	 * @param
	 * 
	 * */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("br.edu.ufab.model.entities");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		
		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		jpaProterties.put("hibernate.hbm2ddl.auto", "update");
		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}
	/**
	 * método que vai configurar o gerenciamento da JPA
	 * @param
	 * 
	 * */
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
