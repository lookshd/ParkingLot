package models;

import models.constants.ParkingLotStatus;
import models.constants.VehicleType;

import java.util.List;

public class ParkingLot extends  BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypeSupported;
    private List<Opreator> opreators;
    private int capacity;
    private BillCalculationStrategy billCalculationStrategy;
    private SlotAllocationStrategy slotAllocationStrategy;

    public ParkingLot(String address, BillCalculationStrategy billCalculationStrategy, int capacity, String name, List<Opreator> opreators, List<ParkingFloor> parkingFloors, ParkingLotStatus parkingLotStatus, SlotAllocationStrategy slotAllocationStrategy, List<VehicleType> vehicleTypeSupported) {
        this.address = address;
        this.billCalculationStrategy = billCalculationStrategy;
        this.capacity = capacity;
        this.name = name;
        this.opreators = opreators;
        this.parkingFloors = parkingFloors;
        this.parkingLotStatus = parkingLotStatus;
        this.slotAllocationStrategy = slotAllocationStrategy;
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

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public List<VehicleType> getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(List<VehicleType> vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }
}
