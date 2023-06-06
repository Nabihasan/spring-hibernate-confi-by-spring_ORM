package com.ms;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration
public class JavaConfiguration {
		
		@Bean
		public EmpEntry empentry() {
			return new EmpEntry();
			}
		@Bean
		public ComboPooledDataSource ds() {
			ComboPooledDataSource cpds=new  ComboPooledDataSource();
			try {
				cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			} catch (PropertyVetoException e) {
				
				e.printStackTrace();
			}
			
			cpds.setJdbcUrl("jdbc:mysql://localhost:3307/hdata");
			cpds.setUser("root");
			cpds.setPassword("1234");
			
			return cpds;
			
		}
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean lf=new LocalSessionFactoryBean();
			lf.setDataSource(ds());
			lf.setPackagesToScan("com.ms");
			
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.put("hibernate.show_sql", "true");
			lf.setHibernateProperties(hibernateProperties);
			
			return lf;
		}
		
}
