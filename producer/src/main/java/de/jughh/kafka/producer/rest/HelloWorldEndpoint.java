package de.jughh.kafka.producer.rest;

import org.aerogear.kafka.SimpleKafkaProducer;
import org.aerogear.kafka.cdi.annotation.KafkaConfig;
import org.aerogear.kafka.cdi.annotation.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import java.util.Random;
import java.util.UUID;

@ApplicationScoped
@Path("/hello")
@KafkaConfig(bootstrapServers = "#{MY_CLUSTER_KAFKA_SERVICE_HOST}:#{MY_CLUSTER_KAFKA_SERVICE_PORT}")
public class HelloWorldEndpoint {

	@Producer
	private SimpleKafkaProducer<String, SensorData> myproducer;

	@GET
	@Produces("text/plain")
	public Response doGet() {

		final Random random = new Random();

		final SensorData data = new SensorData(UUID.randomUUID().toString(), (random.nextInt(1000)+""));

		myproducer.send("sensor_data", data);

		return Response.ok("Hello from Thorntail!").build();
	}
}