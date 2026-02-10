package repository;

import exception.NoParkingSpotFoundException;
import models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingSpotRepository {
    private HashMap<Integer, ParkingSpot> parkingSpots;
    private static int id_counter = 1;

    public ParkingSpotRepository() {
        this.parkingSpots = new HashMap<>();
    }

    public ParkingSpot getParkingSpotById(int id) {
        if(parkingSpots.containsKey(id)){
            return parkingSpots.get(id);
        }
        throw new NoParkingSpotFoundException("No parking spot found with id: " + id);
    }

    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot){
        if (!parkingSpots.containsKey(parkingSpot.getId())) {
            parkingSpot.setId(id_counter++);
        }
        parkingSpots.put(parkingSpot.getId(), parkingSpot);
        return parkingSpot;
    }

    public void delete(int parkingSpotId) {
        parkingSpots.remove(parkingSpotId);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return new ArrayList<>(parkingSpots.values());
    }
}
