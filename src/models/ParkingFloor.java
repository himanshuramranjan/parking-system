package models;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNum;
    private final List<ParkingSpot> parkingSpots;
    private final Set<ParkingSpot> freeParkingSpots;

    public ParkingFloor(int floorNum, List<ParkingSpot> parkingSpots) {
        this.floorNum = floorNum;
        this.parkingSpots = parkingSpots;
        this.freeParkingSpots = getFreeParkingSpots(parkingSpots);
    }

    private Set<ParkingSpot> getFreeParkingSpots(List<ParkingSpot> parkingSpots) {
        return parkingSpots.stream().filter(ParkingSpot::isFree).collect(Collectors.toSet());
    }

    public int getFloorNum() {
        return floorNum;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Set<ParkingSpot> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void addParkingSlot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public void addFreeParkingSpot(ParkingSpot parkingSpot) {
        this.freeParkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        this.freeParkingSpots.remove(parkingSpot);
    }

}
