package com.example;

import com.example.bo.CowAnimal;
import com.example.bo.Food;
import com.example.bo.MilkFood;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

	@GET
	public List<CowAnimal> hello() {
		return CowAnimal.findAll().list();
	}

	@POST
	@Path("/{type}")
	public CowAnimal create(@PathParam String type) {
		CowAnimal cow = new CowAnimal();
		Food food = Food.create(type, (int) (Math.random() * 10));
		cow.setFood(food);
		cow.persist();
		return cow;
	}

}