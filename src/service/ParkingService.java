package service;

import enums.ParkingSpotEnum;
import enums.VehicleType;
import exceptions.SpotNotFoundException;
import models.ParkingFloor;
import models.ParkingSpot;
import models.ParkingTicket;
import models.vehicle.Vehicle;
import strategy.Strategy;

import static enums.ParkingSpotEnum.*;

public class ParkingService {
    private static volatile ParkingService parkingService;
    private DisplayService displayService;

    private ParkingService() {
        displayService = DisplayService.getInstance();
    }

    public static ParkingService getInstance() {
        if(parkingService == null) {
            synchronized (ParkingService.class) {
                if(parkingService == null) {
                    parkingService = new ParkingService();
                }
            }
        }
        return parkingService;
    }

    public ParkingTicket performEntry(Strategy parkingStrategy, ParkingFloor parkingFloor, Vehicle vehicle) throws SpotNotFoundException {
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingSpotEnum parkingSpotEnum = vehicleType.equals(VehicleType.TWO_WHEELER) ? MINI :
                (vehicleType.equals(VehicleType.FOUR_WHEELER) ? COMPACT : LARGE);

        ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum, parkingFloor); // exception handling
        displayService.removeParkingSpot(parkingFloor, parkingSpot);
        return new ParkingTicket(vehicle, parkingSpot, parkingFloor);
    }

    public void performExit(ParkingTicket parkingTicket) {
        displayService.addParkingSpot(parkingTicket.getParkingFloor(), parkingTicket.getParkingSpot());
    }
}
