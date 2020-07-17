package com.police.bikeFinder.bikeFinderApi;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
public class BikeFinderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeFinderApiApplication.class, args);

	}

	@Bean
	public ComboPooledDataSource myDataSource (){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/your_DB_location");
			cpds.setUser("username");
			cpds.setPassword("password");
			cpds.setInitialPoolSize(5);
			cpds.setMinPoolSize(5);
			cpds.setMaxPoolSize(20);
			cpds.setMaxIdleTime(30000);
		}catch (Exception e){
			e.printStackTrace();
		}
		return cpds;
	}


	@Bean()
	public LocalSessionFactoryBean sessionFactory (){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.police.bikeFinder.bikeFinderApi.entity");
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql","true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}


	@Bean
	public PlatformTransactionManager txManager(){
		return new DataSourceTransactionManager(myDataSource());
	}




}

