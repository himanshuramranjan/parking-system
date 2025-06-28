package service;

import models.ParkingFloor;
import models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DisplayService {
    private List<ParkingFloor> parkingFloorList;
    private Map<Integer, List<ParkingSpot>> availableParkingSpots;
    private static volatile DisplayService displayService;

    private DisplayService() {}

    public static DisplayService getInstance() {
        if(displayService == null) {
            synchronized (DisplayService.class) {
                if(displayService == null) {
                    displayService = new DisplayService();
                }
            }
        }
        return displayService;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
        this.availableParkingSpots = getAvailableParkings(parkingFloorList);
    }

    public Map<Integer, List<ParkingSpot>> getAvailableParkingSpots() {
        return availableParkingSpots;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloorList.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloorList.remove(parkingFloor);
    }

    public void addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
        parkingFloor.addFreeParkingSpot(parkingSpot);
        availableParkingSpots.get(parkingFloor.getFloorNum()).add(parkingSpot);
    }

    public void removeParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
        parkingFloor.removeParkingSpot(parkingSpot);
        availableParkingSpots.get(parkingFloor.getFloorNum()).remove(parkingSpot);
    }

    private Map<Integer, List<ParkingSpot>> getAvailableParkings(List<ParkingFloor> parkingFloorList) {
        Map<Integer, List<ParkingSpot>> availableParkings = new HashMap<>();

        for(ParkingFloor parkingFloor : parkingFloorList) {
            int floorNum = parkingFloor.getFloorNum();
            if(!availableParkings.containsKey(floorNum)) {
                availableParkings.put(floorNum, new ArrayList<>(parkingFloor.getFreeParkingSpots()));
            }
        }
        return availableParkings;
    }

}
