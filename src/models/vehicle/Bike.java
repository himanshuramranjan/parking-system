package models.vehicle;

import enums.VehicleType;

public class Bike extends Vehicle {

    protected Bike(String registrationNumber) {
        super(VehicleType.FOUR_WHEELER, registrationNumber);
    }
}
