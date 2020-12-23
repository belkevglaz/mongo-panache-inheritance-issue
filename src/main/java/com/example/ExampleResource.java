package com.example;

import com.example.bo.CowAnimal;
import com.example.bo.MilkFood;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class ExampleResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello() {
		CowAnimal.findAll().stream().forEach(System.out::println);
		return Response.ok().build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create() {
		CowAnimal cow = new CowAnimal();
		cow.setFood(new MilkFood((int) (Math.random() * 10)));
		cow.persist();
		return Response.accepted().build();
	}

}