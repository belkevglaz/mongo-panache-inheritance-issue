package com.example;

import com.example.bo.Animal;
import com.example.bo.Cow;
import com.example.bo.Food;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

	@GET
	public List<Animal> hello() {
		return Animal.findAll().list();
	}

	@POST
	@Path("/{animalType}")
	public Animal create(@PathParam String animalType, @PathParam String food) {

		Animal animal = Animal.createAnimal(animalType);


//		Food food = Food.create(type, (int) (Math.random() * 10));

		animal.persist();

		return animal;
	}

}