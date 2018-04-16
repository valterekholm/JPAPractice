package world.domain;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Country {

	@Id
	private String code;
	private String name;
	private String continent;
	private String region;
	private long population;
	
	@OneToOne
	@JoinColumn(name="capital")
	private City capital;
	
	public Country() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		
	     NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	     String populationAsString = numberFormat.format(population);
	      
	      
		return String.format("%s in %s, population is %s",name,continent,populationAsString) + "\n" +
	"The capital city is: " + capital;
	}
	
	
	
}
