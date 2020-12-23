package com.example.bo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 */
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = EggFood.class, name = "egg"),
		@JsonSubTypes.Type(value = MilkFood.class, name = "milk")
})
@BsonDiscriminator
@JsonDeserialize(using = FoodDeserializer.class)
public interface Food {

	String getType();
}
