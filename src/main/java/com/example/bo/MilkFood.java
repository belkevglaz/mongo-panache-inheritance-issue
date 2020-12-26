package com.example.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 */
@Data
@NoArgsConstructor
@BsonDiscriminator
@ToString
public class MilkFood implements Food {

	private Integer milkContent;

	public MilkFood(Integer milkContent) {
		this.milkContent = milkContent;
	}

}
