package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
