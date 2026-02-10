package repository;

import exception.NoVehicleFoundException;
import models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRepository {
    private HashMap<Integer, Vehicle> vehicles;
    private static int id_counter = 1;

    public VehicleRepository() {
        this.vehicles = new HashMap<>();
    }

    public Vehicle getVehicleById(int id) {
        if(vehicles.containsKey(id)){
            return vehicles.get(id);
        }
        throw new NoVehicleFoundException("No vehicle found with id: " + id);
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        if (!vehicles.containsKey(vehicle.getId())) {
            vehicle.setId(id_counter++);
        }
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    public void delete(int vehicleId) {
        vehicles.remove(vehicleId);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles.values());
    }
}
