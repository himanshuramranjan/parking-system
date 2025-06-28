package strategy;

import enums.ParkingSpotEnum;
import exceptions.SpotNotFoundException;
import models.ParkingFloor;
import models.ParkingSpot;

import java.util.List;

public class NearestFirstParkingStrategy implements Strategy{

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum, ParkingFloor parkingFloor) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots = parkingFloor.getFreeParkingSpots().stream().filter(parkingSpot -> parkingSpot.getParkingSpotEnum().equals(parkingSpotEnum)).toList();
        if(parkingSpots.isEmpty()) throw new SpotNotFoundException("Spot not found in nearest parking");
        return parkingSpots.get(0);
    }
}
