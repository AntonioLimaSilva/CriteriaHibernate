package br.com.luciano.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidoPU");
	
	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

}