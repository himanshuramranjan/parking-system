package models;

import enums.ParkingSpotEnum;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpot {
    private static final AtomicInteger count = new AtomicInteger();
    private final int id;
    private boolean isFree;
    private ParkingSpotEnum parkingSpotEnum;

    protected ParkingSpot(ParkingSpotEnum parkingSpotEnum) {
        this.id = count.incrementAndGet();
        this.parkingSpotEnum = parkingSpotEnum;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }
}
