package world;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
import world.domain.*;

public class JPADemo {
	/**
	 * * Find cities in database by name. * @param name is the name of city to find.
	 */
	public static void findCity(String name) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factory.createEntityManager();
		
		
		Query query = em.createQuery("SELECT c from City c where c.name = :name");
		query.setParameter("name", name);
		List<City> cities = query.getResultList();
		System.out.printf("Found %d matches for %s\n", cities.size(), name);
		for (City c : cities)
			System.out.println(c);
	}
	
	public static void findCountry() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT c from Country c where c.name = :name");
		
		
		String name = "";
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Country to find: ");
			name = scanner.nextLine();
			if(name.length()>0) {
				System.out.println("Ska söka på " + name);
				query.setParameter("name", name);
				try {
					Country country = (Country) query.getSingleResult();
					System.out.println(country);//"%s in %s, population: %,d \n", country.getName(), country.getContinent(), country.getPopulation());
				}
				catch(Exception ex) {
					System.out.println("No matches for " + name);
				}	
			}
			else {
				System.out.println("Entered nothing, exiting...");
				scanner.close();
				em.close();
				factory.close();
				return;
			}
		}while(true);
	}
	
	
	

	public static void main(String[] args) {
		//findCity("Los Angeles");
		findCountry();
	}

}