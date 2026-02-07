package models;

import models.constants.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSpot> parkingSpot;
    private List<Gates> gates;
    private ParkingFloorStatus parkingFloorStatus;
    private Opreator opreator;

    public ParkingFloor(int floorNo, List<Gates> gates, Opreator opreator, ParkingFloorStatus parkingFloorStatus, List<ParkingSpot> parkingSpot) {
        this.floorNo = floorNo;
        this.gates = gates;
        this.opreator = opreator;
        this.parkingFloorStatus = parkingFloorStatus;
        this.parkingSpot = parkingSpot;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public List<Gates> getGates() {
        return gates;
    }

    public void setGates(List<Gates> gates) {
        this.gates = gates;
    }

    public Opreator getOpreator() {
        return opreator;
    }

    public void setOpreator(Opreator opreator) {
        this.opreator = opreator;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<ParkingSpot> getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(List<ParkingSpot> parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
