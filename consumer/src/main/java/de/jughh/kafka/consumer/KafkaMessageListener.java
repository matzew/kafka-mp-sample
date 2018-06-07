package de.jughh.kafka.consumer;

import org.aerogear.kafka.cdi.annotation.Consumer;

import java.util.logging.Logger;

public class KafkaMessageListener {

    private static Logger logger = Logger.getLogger(KafkaMessageListener.class.getName());

    @Consumer(topics = "sensor_data", groupId = "testGroup", offset = "earliest")
    public void onSensorData(final SensorValue sv) {


        logger.warning("I just got: " + sv);
    }
}
