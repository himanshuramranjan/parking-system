package models.user;

import enums.UserRole;
import exceptions.SpotNotFoundException;
import models.ParkingFloor;
import models.ParkingTicket;
import models.vehicle.Vehicle;
import service.ParkingService;
import strategy.FarthestFirstParkingStrategy;

public class EntryParkingAttendant extends User {

    private ParkingService parkingService;
    protected EntryParkingAttendant(String name) {
        super(name, UserRole.PARKING_ATTENDANT);
        this.parkingService = ParkingService.getInstance();
    }

    public ParkingTicket bookParkingTicket(Vehicle vehicle, ParkingFloor parkingFloor) throws SpotNotFoundException {
        return parkingService.performEntry(new FarthestFirstParkingStrategy(), parkingFloor, vehicle);
    }

}
