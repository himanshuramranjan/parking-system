package models.vehicle;

import enums.VehicleType;

public class Car extends Vehicle {

    protected Car(String registrationNumber) {
        super(VehicleType.FOUR_WHEELER, registrationNumber);
    }
}
