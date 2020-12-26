package com.example.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@Data
@NoArgsConstructor
@BsonDiscriminator()
public class EggFood implements Food {

	private Integer category;

	public EggFood(Integer category) {
		this.category = category;
	}

}
