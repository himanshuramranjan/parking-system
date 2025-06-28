package strategy;
import enums.ParkingSpotEnum;
import exceptions.SpotNotFoundException;
import models.ParkingFloor;
import models.ParkingSpot;

import java.util.List;

public class FarthestFirstParkingStrategy implements Strategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum, ParkingFloor parkingFloor) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots = parkingFloor.getFreeParkingSpots().stream().filter(parkingSpot -> parkingSpot.getParkingSpotEnum().equals(parkingSpotEnum)).toList();
        if(parkingSpots.isEmpty()) throw new SpotNotFoundException("Spot not found in farthest parking");
        return parkingSpots.get(parkingSpots.size() - 1);
    }
}
