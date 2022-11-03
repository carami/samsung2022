package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRun {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저가 생성될 때 영속성 컨텍스트가 생성된다!!
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
//등록!! 
//			Product product = new Product();
////			product.setId(3L);
//			product.setName("pen22");
//			product.setPrice(2000); // 비영속상태
//			
//			System.out.println("---------------------");
//			em.persist(product); // 영속!!
//			System.out.println("---------------------");
//			
//			
//			
			Product product2 = new Product();
			product2.setId(5L);
			product2.setName("cup");
			product2.setPrice(2000); // 비영속상태
			
			em.persist(product2);
			System.out.println("---------------------");

			//수정~~     
			Product findProduct =	em.find(Product.class, 5L);  //스냅샷 
			findProduct.setName("test");
			findProduct.setPrice(5000);
			
			if( product2 == findProduct)
				System.out.println("같은 객체!!");
//			
//						
//			findProduct.setName("pen1111");
//			findProduct.setPrice(3000);   // 마지막 커맷될때 스냅샷과 비교해서 달라진 값이 있을때 update 한다. 
		//삭제 
			
//			Product findProduct =	em.find(Product.class, 1L);
//			em.remove(findProduct);
			
			
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {

			em.close();
			emf.close();
		}
	}

}
