package sampleJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persistence.Customer;

public class UpdateEntity {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sampleJpa");
		EntityManager em = emf.createEntityManager();
		try {
			Customer cus1 = new Customer();
			cus1.setName("TONG1");		
			persist(em, cus1);
			
			Customer cus2 = em.find(Customer.class, 1);
			Customer cus3 = em.find(Customer.class, 1);
			cus2.setName("TONG2");
			merge(em, cus2);
			cus3.setName("TONG3");
			persist(em, cus3);
		}finally {
			emf.close();
			em.close();
		}

	}

	private static void persist(EntityManager em, Customer cus) {
		em.getTransaction().begin();
		em.persist(cus);
		em.getTransaction().commit();
	}
	private static void merge(EntityManager em, Customer cus) {
		em.getTransaction().begin();
		em.merge(cus);
		em.getTransaction().commit();
	}

}
