package de.jughh.kafka.producer.rest;

public class SensorData {

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SensorData(String id, String value) {
        this.id = id;
        this.value = value;
    }


    @Override
    public String toString() {
        return "SensorData{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
