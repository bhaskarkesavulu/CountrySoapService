package com.soap.example.endpoint;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.web.consumer.stub.Country;
import com.web.consumer.stub.Currency;

@Component
public class CountryRepository {

	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initData() {

		Country c1 = new Country();
		c1.setName("Spain");
		c1.setCapital("MADRID");
		c1.setPopulation(46704314);
		c1.setCurrency(Currency.EUR);

		Country c2 = new Country();
		c2.setName("GUERNSEY");
		c2.setCapital("SAINT PETER PORT");
		c2.setPopulation(84079811);
		c2.setCurrency(Currency.GBP);

		Country c3 = new Country();
		c3.setName("POLAND");
		c3.setCapital("WARSAW");
		c3.setPopulation(10000);
		c3.setCurrency(Currency.PLN);

		Country c4 = new Country();
		c4.setName("GERMANY");
		c4.setCapital("Berlin");
		c4.setPopulation(100);
		c4.setCurrency(Currency.EUR);

		countries.put("Spain", c1);
		countries.put("GUERNSEY", c2);
		countries.put("POLAND", c3);
		countries.put("GERMANY", c4);

	}

	public Country findCountry(String name) {
		return countries.get(name);
	}
}