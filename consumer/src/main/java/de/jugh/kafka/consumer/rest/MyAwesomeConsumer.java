package de.jugh.kafka.consumer.rest;

import org.aerogear.kafka.cdi.annotation.Consumer;
import org.aerogear.kafka.cdi.annotation.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by matzew on 9/28/17.
 */
@KafkaConfig(bootstrapServers = "#{KAFKA_SERVICE_HOST}:#{KAFKA_SERVICE_PORT}")
public class MyAwesomeConsumer {

    private Logger logger = LoggerFactory.getLogger(MyAwesomeConsumer.class);

    @Consumer(topics = "jug_hessen", groupId = "JUG_H_Consumers")
    public void onMessage(final String key, final ReceivedPerson person) {

        logger.error("We got this dude: " + person.getName());
    }

}
