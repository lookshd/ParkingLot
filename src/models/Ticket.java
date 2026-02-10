package models;

import java.time.LocalDateTime;

public class Ticket extends  BaseModel {
    private Vehicle vehicle;
   private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private Gate entryGate;

    public Ticket() {
    }
    public Ticket(Gate entryGate, LocalDateTime entryTime, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryGate = entryGate;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
