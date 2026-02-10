package services;

import models.*;
import models.constants.BillStatus;
import models.constants.ParkingSpotStatus;
import models.constants.ParkingSpotType;
import models.constants.PaymentMode;
import repository.*;
import services.SpotAllocationStrategy.SpotAllocationStrategy;
import services.SpotAllocationStrategy.SpotAllocationStrategyFactory;
import services.billingStrategy.BillCalculationStrategies;
import services.billingStrategy.BillCalculationStrategy;
import services.billingStrategy.BillCalculationStrategyFactory;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class ParkingLotService {
    private ParkingSpotRepository parkingSpotRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private BillRepository billRepository;

    public ParkingLotService() {
        this.parkingSpotRepository = new ParkingSpotRepository();
        this.ticketRepository = new TicketRepository();
        this.parkingLotRepository = new ParkingLotRepository();
        this.gateRepository = new GateRepository();
        this.billRepository = new BillRepository();
    }

    public Ticket genrateTicket(Vehicle vehicle, int parkingLotId, int gateId){
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        Gate gate = gateRepository.getGateById(gateId);
        SpotAllocationStrategy strategyFactory = SpotAllocationStrategyFactory.getSpotAllocationStrategy();
        ParkingSpot parkingSpot = strategyFactory.getSpotForVechicleType(parkingLot, vehicle);

        Ticket ticket = new Ticket();
        ticket.setEntryGate(gate);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);

        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingLot.setCurrentOccupancy(parkingLot.getCurrentOccupancy()+1);
        parkingLotRepository.saveParkingLot(parkingLot);
        return ticketRepository.saveTicket(ticket);
    }

    public  Bill genrateBill(int ticketId,int parkingLotId,int gateId){
        Ticket ticket = ticketRepository.getTicketById(ticketId);
        LocalDateTime exitTime= LocalDateTime.now();
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        double occupancyRatio = (double)parkingLot.getCurrentOccupancy()/parkingLot.getCapacity();
        BillCalculationStrategy strategyFactory = BillCalculationStrategyFactory.getBillCalculation(BillCalculationStrategies.SIMPLE);
        long billAmount = strategyFactory.genrateBill(ticket,occupancyRatio);


        Bill bill = new Bill();
        bill.setExitTime(exitTime);
        bill.setAmount(billAmount);
        bill.setPaymentMode(PaymentMode.UPI);
        bill.setBillStatus(BillStatus.PAID);
        bill.setPaymentRefrenceNo("txn123323");

        ParkingSpot parkingSpot =  ticket.getParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FREE);
        parkingLot.setCurrentOccupancy(parkingLot.getCurrentOccupancy()-1);
        parkingSpot.setVehicle(null);
        parkingSpotRepository.saveParkingSpot(parkingSpot);
        parkingLotRepository.saveParkingLot(parkingLot);
        return billRepository.saveBill(bill);
    }


}
