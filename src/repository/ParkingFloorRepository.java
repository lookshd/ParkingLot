package repository;

import exception.NoParkingFloorFoundException;
import models.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> parkingFloors;
    private static int id_counter = 1;

    public ParkingFloorRepository() {
        this.parkingFloors = new HashMap<>();
    }

    public ParkingFloor getParkingFloorById(int id) {
        if(parkingFloors.containsKey(id)){
            return parkingFloors.get(id);
        }
        throw new NoParkingFloorFoundException("No parking floor found with id: " + id);
    }

    public ParkingFloor saveParkingFloor(ParkingFloor parkingFloor){
        if (!parkingFloors.containsKey(parkingFloor.getId())) {
            parkingFloor.setId(id_counter++);
        }
        parkingFloors.put(parkingFloor.getId(), parkingFloor);
        return parkingFloor;
    }

    public void delete(int parkingFloorId) {
        parkingFloors.remove(parkingFloorId);
    }

    public List<ParkingFloor> getAllParkingFloors() {
        return new ArrayList<>(parkingFloors.values());
    }
}
