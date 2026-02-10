package models;

import models.constants.ParkingLotStatus;
import models.constants.VehicleType;
import services.SpotAllocationStrategy.SpotAllocationStrategy;
import services.billingStrategy.BillCalculationStrategy;

import java.util.List;

public class ParkingLot extends  BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypeSupported;
    private List<Opreator> opreators;
    private int currentOccupancy;
    private int capacity;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

   public ParkingLot(){}

    public ParkingLot(String address, BillCalculationStrategy billCalculationStrategy, int capacity, String name, List<Opreator> opreators, List<ParkingFloor> parkingFloors, ParkingLotStatus parkingLotStatus, SpotAllocationStrategy spotAllocationStrategy, List<VehicleType> vehicleTypeSupported) {
        this.address = address;
        this.billCalculationStrategy = billCalculationStrategy;
        this.capacity = capacity;
        this.name = name;
        this.opreators = opreators;
        this.parkingFloors = parkingFloors;
        this.parkingLotStatus = parkingLotStatus;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Opreator> getOpreators() {
        return opreators;
    }

    public void setOpreators(List<Opreator> opreators) {
        this.opreators = opreators;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SpotAllocationStrategy getSlotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public List<VehicleType> getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(List<VehicleType> vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }
}
