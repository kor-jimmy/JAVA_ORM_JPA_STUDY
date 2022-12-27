package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		/*
		 *  EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유
		 * */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		/**
		 * EntityManager는 쓰레드간에 공유 X (사용하고 버려야 한다.)
		 */
		EntityManager em = emf.createEntityManager();

		// JPA는 트랜잭션 단위가 매우 중요하다. 모든 데이터 변경은 트랜잭션 안에서 실행
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			
			// 저장
			Member member = new Member();
			member.setId(2L);
			member.setName("HelloB");

			em.persist(member);
			
			// 조회
			Member findMember = em.find(Member.class, "1L");
			System.out.println("findMember.id ==>" + findMember.getId());
			System.out.println("findMember.name ==>" + findMember.getName());
			
			// 수정
			findMember.setName("HelloJPA");
			
			// 삭제
			// em.remove(findMember);

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
