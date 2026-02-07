package models;

import models.constants.ParkingSpotStatus;
import models.constants.VehicleType;

public class ParkingSpot {
    private int parkingNo;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private  ParkingSpot parkingSpot;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot(int parkingNo, ParkingSpot parkingSpot, ParkingSpotStatus parkingSpotStatus, Vehicle vehicle, VehicleType vehicleType) {
        this.parkingNo = parkingNo;
        this.parkingSpot = parkingSpot;
        this.parkingSpotStatus = parkingSpotStatus;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
    }

    public int getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(int parkingNo) {
        this.parkingNo = parkingNo;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
