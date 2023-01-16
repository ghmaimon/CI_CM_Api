package com.cicm.zonesservice.exception;

public class PlantNotFoundException extends CICMException{
    public PlantNotFoundException(String plantId) {
        super("Plant with id + " + plantId + " not found");
    }
}
