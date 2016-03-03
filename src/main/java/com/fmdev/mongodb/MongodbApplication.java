package com.fmdev.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {
	
	@Autowired RestaurantRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Kill our fake restaurant
		repository.deleteByName("Great Fake Restaurant");
		
		// Create fake restaurant
		Restaurant myFake = new Restaurant("Great Fake Restaurant", 100, 1000);
		myFake.setLocation(new Location(new double[]{-73.8556917, 40.8481555} , "Point"));
		repository.save(myFake);
		
		System.out.println("\n********** Restaurants found within 100m of 'Big Deal Supermarket' ***************");
		for (GeoResult<Restaurant> restaurant : repository.findByLocationNear(new Point(-73.8564608, 40.8484129), 
				new Distance(0.1, Metrics.KILOMETERS))) {
            System.out.println(restaurant.getContent());
        }
        System.out.println();
        
        System.out.println("\n*********** Restaurants with rating > 0 ****************");
        for (Restaurant restaurant : repository.findByRatingGreaterThan(0)) {
        	System.out.println(restaurant);
        }
        System.out.println();
        
        System.out.println("\n************ Native query example ***********************");
        for (Restaurant restaurant: repository.findByRestaurantName("Great Fake Restaurant")) {
        	System.out.println(restaurant);
        }
       
	}

	
}
