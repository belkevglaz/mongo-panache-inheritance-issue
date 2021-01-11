package com.example.bo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "animals")
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "_t"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Cow.class, name = "cow"),
		@JsonSubTypes.Type(value = Chicken.class, name = "chicken")

})
public abstract class Animal extends PanacheMongoEntity {

	 public abstract String getType();

	 public static Animal createAnimal(String animalType) {
		 switch (animalType) {
			 case "cow":
				 return new Cow();
			 case "chicken":
				 return new Chicken();
			 default:
				 throw new IllegalArgumentException();
		 }
	 }

}
