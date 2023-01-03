package jpastudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Member member = new Member();
			member.setUsername("member1");	
			// setter를 사용하지 않도록
			member.changeTeam(team);
			
			em.persist(member);
			
			// 메소드 활용으로 변경!
//			team.getMembers().add(member);		

//			em.flush();
//			em.clear();

			Member findMemeber = em.find(Member.class, member.getId());

//			// 객체 그래프 탐색
//			// 참조를 사용해서 연관관계 조회
//			Team findTeam = findMemeber.getTeam();
//
//			System.out.println("findTeam = " + findTeam.getName());
//			
//			// 수정
//			Team newTeam = em.find(Team.class, 100L);
//			findMemeber.setTeam(newTeam);

			List<Member> members = findMemeber.getTeam().getMembers();
			for (Member m : members) {
				System.out.println("member = " + m.getUsername());
			}

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
