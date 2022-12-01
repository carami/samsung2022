package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRun {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저가 생성 될 때 영속성 컨텍스트가 생성된다.
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {

//등록!!  
			Product product = new Product();
//			product.setId(6L);
			product.setName("notebook22");
			product.setPrice(30000); // 지금까지는 비영속 상태임.
			
			
			System.out.println("before~~~");
			em.persist(product); // 영속 상태가 됨.   영속상태가 된다고 해서 바로 DB에 적용이 되는 것은  아니다!!!
			System.out.println("after~~~~");
			
			
//수정        
//			Product findProduct = em.find(Product.class, 4L);
//			findProduct.setName("update test222");
//			findProduct.setPrice(20000);
//			
//			
//			findProduct.setName("phone");
//			findProduct.setPrice(3000);
			
//			if(product == findProduct)
//				System.out.println("같은 객체입니다.");
			
//			
//			Product delProduct = 	em.find(Product.class, 2L);
//			em.remove(delProduct);
			
			
			
			tx.commit();
			
			System.out.println("commit after!!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			
			em.close();
			emf.close();
		}

	}

}
