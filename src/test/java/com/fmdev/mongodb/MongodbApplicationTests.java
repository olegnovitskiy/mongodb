package com.fmdev.mongodb;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class MongodbApplicationTests {
	
	@Autowired RestaurantRepository repository;
	
	@Test
	public void saveAndGetId() {
		Restaurant restaurant = repository.save(new Restaurant("DummyTestRestaurant", 10.0, 20));
		assertEquals("DummyTestRestaurant", restaurant.getName());
	}
}
