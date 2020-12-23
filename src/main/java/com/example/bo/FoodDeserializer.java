package com.example.bo;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class FoodDeserializer extends JsonDeserializer<Food> {
	@Override
	public Food deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) parser.getCodec();
		ObjectNode root = mapper.readTree(parser);
		String type = root.has("type") ? root.get("type").textValue() : null;
		if (type.equals("milk")) {
			return mapper.readValue(root.toString(), MilkFood.class);
		} else
			return mapper.readValue(root.toString(), EggFood.class);
	}
}
