package strategy;

import enums.ParkingSpotEnum;
import exceptions.SpotNotFoundException;
import models.ParkingFloor;
import models.ParkingSpot;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum, ParkingFloor floor) throws SpotNotFoundException;
}
