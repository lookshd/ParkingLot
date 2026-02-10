package services.SpotAllocationStrategy;

import exception.NoParkingSpotAvailableException;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import models.constants.ParkingLotStatus;
import models.constants.ParkingSpotStatus;
// we have parking lot and vehicle details

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot getSpotForVechicleType(ParkingLot parkingLot, Vehicle vehicle) {
            if(parkingLot.getParkingLotStatus()== ParkingLotStatus.AVAILABLE)
            {
                for(ParkingFloor floor: parkingLot.getParkingFloors())
                {
                    for(ParkingSpot spot : floor.getParkingSpot())
                    {
                          if(spot.getParkingSpotStatus().equals( ParkingSpotStatus.FREE) && spot.getVehicleType().equals(vehicle.getVehicleType()))
                          {
                              return spot;
                          }
                    }
                }
            }
            throw new NoParkingSpotAvailableException("No available parking spot for vehicle type " + vehicle.getVehicleType());
    }
}
