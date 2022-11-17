package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRun {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
//등록 
			// 엔티티생성 -- 비영속
			Product product = new Product();
//			product.setId(2L);
			product.setName("pen");
			product.setPrice(3000);
			// -- 여기까지는 product entity는 비영속 상태이다.

			em.persist(product); // 영속 상태로 바뀜!! -- 바로 DB에 반영되는 것은 아님!!  
			
			
			//수정 
			Product findProduct = 	em.find(Product.class, 2L);
			
			if(product == findProduct)
				System.out.println("product와 findProduct 는 같아요.");
			
			
			findProduct.setName("test");
			findProduct.setName("test2222");		
			
//			findProduct.setName("cup");
//			findProduct.setPrice(5000);
			
			
			//삭제
			Product findProduct2 = 	em.find(Product.class, 2L);
			em.remove(findProduct2);
			
			System.out.println("commit 실행전!!!");

			// 모든일이 정상적으로 처리 되었다면 commit!!
			tx.commit();
			
			System.out.println("commit 실행후!!!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
