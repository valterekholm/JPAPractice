package world.domain;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;

/** * A City in a country. * @author masn */
@Entity
public class City {
	// A default constructor is needed for JPA to work, if you have other
	// construcstors you need to add it manually.
	@Id
	private Integer id;
	private String name;
	private String district;
	private int population;
	// toString Implementation of your choice
	@Override
	public String toString() {
	     NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	     String populationAsString = numberFormat.format(population);
	     
		return String.format("%s, district %s, pop. %s", name, district, populationAsString);//name + ", district " + district + ", pop. " + population;
	}
	
	
}
