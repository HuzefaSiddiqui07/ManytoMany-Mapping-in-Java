package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		User user1 = new User();
		user1.setUsername("Huzefa");
		user1.setEmail("huzefa234@gmail.com");

		User user2 = new User();
		user2.setUsername("Avesh");
		user2.setEmail("avesh456@gmail.com");

		Nominee nominee1 = new Nominee();
		nominee1.setName("Priyanka");

		Nominee nominee2 = new Nominee();
		nominee2.setName("Sujit");

		Nominee nominee3 = new Nominee();
		nominee3.setName("Mayuri");

		user1.getNomineeList().add(nominee1);
		user1.getNomineeList().add(nominee2);
		user1.getNomineeList().add(nominee3);

		user2.getNomineeList().add(nominee2);
		user2.getNomineeList().add(nominee3);

		nominee1.getUserList().add(user1);
		nominee2.getUserList().add(user1);
		nominee3.getUserList().add(user1);

		nominee1.getUserList().add(user2);
		nominee3.getUserList().add(user2);

		session.save(user1);
		session.save(user2);

		transaction.commit();
		session.close();
		sessionFactory.close();

		System.out.println("Record Save Successfully...");

	}

}
