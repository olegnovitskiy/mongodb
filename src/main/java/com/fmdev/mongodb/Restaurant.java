package com.fmdev.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="restaurants")
public class Restaurant {
	private String id;
	private String name;
	private double rating;
	private int comments;
	private Location location;
	
	public Restaurant() {}
	
	public Restaurant(String name, double rating, int comments) {
		this.name = name;
		this.rating = rating;
		this.comments = comments;
	}
	
}
