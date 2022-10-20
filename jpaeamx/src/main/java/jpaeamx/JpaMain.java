package jpaeamx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
//등록!! 
			//비영속 상태 
			Product product = new Product();
//			product.setId(3L);
			product.setName("핸드크림");
			product.setPrice(3000);
			System.out.println("persist 전");
			em.persist(product); //영속 상태로 바꿔줌.  영속상태로 바뀌는 즉시 DB에 동기화되는것은 아니다!!!! 
			System.out.println("persist 후");
			
//수정 
//			Product findProduct =  em.find(Product.class, 3L);
//			System.out.println(findProduct.getPrice());
//			findProduct.setPrice(2000);
//			System.out.println(findProduct.getPrice());
//			findProduct.setPrice(5000);
//			findProduct.setName("컵");
//			System.out.println(findProduct);
//			findProduct.setPrice(1000);
//			findProduct.setName("볼펜");
//			
//			if(product == findProduct)
//				System.out.println("==   두 객체는 같은 객체 입니다^^ ");
//			
			
		//삭제
//			Product findProduct2 = em.find(Product.class, 2L);
//			em.remove(findProduct2);
			
			
			
			tx.commit();
			System.out.println("commit 후");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		em.close();
		emf.close();
	}

}
