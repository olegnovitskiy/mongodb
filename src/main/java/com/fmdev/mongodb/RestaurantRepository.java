package com.fmdev.mongodb;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

	GeoResults<Restaurant> findByLocationNear(Point point, Distance distance);

	List<Restaurant> findByRatingGreaterThan(int rating);

	@Query(value = "{ 'name': ?0}", fields="{'name':1, 'rating':1, comments:1 }")
	List<Restaurant> findByRestaurantName(@Param(value = "name") String name);

	void deleteByName(String name);
}