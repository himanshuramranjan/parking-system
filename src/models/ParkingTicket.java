package models;

import models.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {

    private static final AtomicInteger count = new AtomicInteger();
    private final int id;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final ParkingFloor parkingFloor;
    private final LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot, ParkingFloor parkingFloor) {
        this.id = count.incrementAndGet();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingFloor = parkingFloor;
        this.entryTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }
}
