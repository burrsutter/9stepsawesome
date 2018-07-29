package com.burrsutter.swarmdemo.rest;


import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorldEndpoint {
    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from WildFly Swarm! " + new java.util.Date() + " on " + hostname).build();
	}
}