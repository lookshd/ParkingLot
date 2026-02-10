package services;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.constants.*;
import repository.*;

import java.util.ArrayList;
import java.util.List;

public class IntializationService {
    private GateRepository gateRepository;
    private OpreatorRepository opreatorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private  ParkingSpotRepository parkingSpotRepository;

    public IntializationService() {
        this.gateRepository = new GateRepository();
        this.opreatorRepository = new OpreatorRepository();
        this.parkingLotRepository = new ParkingLotRepository();
        this.parkingFloorRepository = new ParkingFloorRepository();
        this.parkingSpotRepository = new ParkingSpotRepository();
    }

    void init(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Safest Parking Lot");
        parkingLot.setAddress("3348, Hanuman Mandir, Karol Bagh, New Delhi");
        parkingLot.setCapacity(100);
        parkingLot.setParkingLotStatus(ParkingLotStatus.AVAILABLE);
        parkingLot.setVehicleTypeSupported(List.of(VehicleType.TWO_WHEELER,VehicleType.FOUR_WHEELER));
        parkingLotRepository.saveParkingLot(parkingLot);

        for(int i=0;i<10;i++)
        {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNo(i);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for(int j=0;j<10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setParkingNo(i+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FREE);
                parkingSpot.setVehicleType(j%2==0?VehicleType.TWO_WHEELER:VehicleType.FOUR_WHEELER);
                parkingSpotRepository.saveParkingSpot(parkingSpot);
                parkingSpots.add(parkingSpot);
            }
            Gate entryGate =new Gate();
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate= gateRepository.saveGate(entryGate);

            Gate exitGate =new Gate();
            exitGate.setGateType(GateType.EXIT);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate= gateRepository.saveGate(exitGate);

            parkingFloor.setGates(List.of(entryGate,exitGate));
            parkingFloor.setParkingSpot(parkingSpots);
            parkingFloorRepository.saveParkingFloor(parkingFloor);
        }
    }


}

