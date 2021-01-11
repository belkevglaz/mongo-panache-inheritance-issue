package com.example.bo;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 */
@MongoEntity(collection = "animals")
public class Cow extends Animal {

	@BsonProperty(useDiscriminator = true, value = "food")
	private Food food;

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String getType() {
		return "cow";
	}

	@Override
	public String toString() {
		return "CowAnimal{" +
				"food=" + food +
				'}';
	}
}
