package com.ms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpEntry {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveData(Emp emp) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(emp);
		tr.commit();
		session.close();
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
		EmpEntry empEntry = context.getBean("empentry", EmpEntry.class);
		Emp e1 = new Emp(124, "neejjnn", "accounts", "executive", 50000);

		empEntry.saveData(e1);
		System.out.println("Data Stored....");
	}

}
