package de.jugh.kafka.producer.rest;

import org.aerogear.kafka.SimpleKafkaProducer;
import org.aerogear.kafka.cdi.annotation.KafkaConfig;
import org.aerogear.kafka.cdi.annotation.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.UUID;

@ApplicationScoped
@Path("/hello")
@KafkaConfig(bootstrapServers = "#{KAFKA_SERVICE_HOST}:#{KAFKA_SERVICE_PORT}")
public class HelloWorldEndpoint {

	@Producer
	private SimpleKafkaProducer<String, Person> myproducer;

	@GET
	@Produces("text/plain")
	public Response doGet() {

		final Person p = new Person();
		p.setName("Seppel");


		myproducer.send("jug_hessen", UUID.randomUUID().toString(), p);

		return Response.ok("Hello from WildFly Swarm!").build();
	}
}