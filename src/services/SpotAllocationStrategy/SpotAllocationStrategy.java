package services.SpotAllocationStrategy;

import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot getSpotForVechicleType(ParkingLot parkingLot, Vehicle vehicle);
}
