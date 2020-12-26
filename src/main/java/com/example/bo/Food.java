package com.example.bo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 *
 */
@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "_t")
@JsonSubTypes({
	@JsonSubTypes.Type(value = EggFood.class, name = "egg"),
	@JsonSubTypes.Type(value = MilkFood.class, name = "milk")
})
@BsonDiscriminator()
public interface Food {

	public static Food create(String type, Integer param) {
		switch (type) {
			case "egg":
				return new EggFood(param);
			case "milk":
				return new MilkFood(param);
			default:
				throw new IllegalArgumentException();
		}
	}

}
