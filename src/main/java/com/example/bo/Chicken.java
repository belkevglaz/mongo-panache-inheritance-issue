package com.example.bo;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection = "animals")
public class Chicken extends Animal{
	@Override
	public String getType() {
		return "chicken";
	}
}
