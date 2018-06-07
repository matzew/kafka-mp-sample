package de.jughh.kafka.consumer;

import org.aerogear.kafka.cdi.annotation.KafkaConfig;

@KafkaConfig(bootstrapServers = "#{MY_CLUSTER_KAFKA_SERVICE_HOST}:#{MY_CLUSTER_KAFKA_SERVICE_PORT}")
public class ConfigBean {

}