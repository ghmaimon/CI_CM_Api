package com.cicm.zonesservice.exception;

public class SensorNotFoundException extends CICMException{
    public SensorNotFoundException(String sensorId) {
        super("Sensor with id + " + sensorId + " not found");
    }
}
