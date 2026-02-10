package repository;

import exception.NoParkingLotFoundException;
import models.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> parkingLots;
    private static int id_counter = 1;

    public ParkingLotRepository() {
        this.parkingLots = new HashMap<>();
    }

    public ParkingLot getParkingLotById(int id) {
        if(parkingLots.containsKey(id)){
            return parkingLots.get(id);
        }
        throw new NoParkingLotFoundException("No parking lot found with id: " + id);
    }

    public ParkingLot saveParkingLot(ParkingLot parkingLot){
        if (!parkingLots.containsKey(parkingLot.getId())) {
            parkingLot.setId(id_counter++);
        }
        parkingLots.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

    public void delete(int parkingLotId) {
        parkingLots.remove(parkingLotId);
    }

    public List<ParkingLot> getAllParkingLots() {
        return new ArrayList<>(parkingLots.values());
    }
}
