package sampleJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persistence.Customer;

public class CreateEntity {
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sampleJpa");
			EntityManager em = emf.createEntityManager();
			try {
				// Create Entity
				Customer cus = new Customer();
				cus.setName("Customer 1");
				persist(em, cus);
		
	
				cus.setName("Customer 2");
				persist(em, cus);
				
				
				cus.setName("Custmer 3");
				persist(em, cus);
				
				cus.setName("Custmer 4");
				persist(em, cus);
			
			}finally {
				em.close();
				emf.close();
			}
			
		}

		private static void persist(EntityManager em, Customer cus) {
			 em.getTransaction().begin();
			 em.persist(cus);
			 em.getTransaction().commit();
		}
}
