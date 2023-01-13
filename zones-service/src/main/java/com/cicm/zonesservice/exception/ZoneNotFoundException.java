package com.cicm.zonesservice.exception;

public class ZoneNotFoundException extends CICMException{
    public ZoneNotFoundException(String zoneId) {
        super("Zone with id + " + zoneId + " not found");
    }
}
