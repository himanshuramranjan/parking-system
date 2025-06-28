package models.vehicle;

import enums.VehicleType;

public class Truck extends Vehicle {
    protected Truck(String registrationNumber) {
        super(VehicleType.SIX_WHEELER, registrationNumber);
    }
}
