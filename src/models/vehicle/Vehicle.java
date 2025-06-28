package models.vehicle;

import enums.VehicleType;

public abstract class Vehicle {

    private final String registrationNumber;
    private final VehicleType vehicleType;

    protected Vehicle(VehicleType vehicleType, String registrationNumber) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public String getId() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
