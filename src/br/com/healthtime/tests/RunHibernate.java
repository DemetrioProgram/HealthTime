package br.com.healthtime.tests;

import org.hibernate.cfg.Configuration;

public class RunHibernate {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg.xml");
		config.configure().buildSessionFactory().openSession();

	}

}
