package com.cicm.zonesservice.exception;

public class IrrigationMachineNotFoundException extends CICMException{
    public IrrigationMachineNotFoundException(String machineId) {
        super("Irrigation machine with id + " + machineId + " not found");
    }
}
