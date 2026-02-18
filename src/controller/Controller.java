package controller;

import models.Bill;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import models.constants.VehicleType;
import repository.ParkingLotRepository;
import services.IntializationService;
import services.ParkingLotService;

import java.util.Scanner;

public class Controller {
    private final ParkingLotService parkingLotService;
    private final Scanner scanner;
    private final IntializationService intializationService;

    public Controller(){
        this.parkingLotService = new ParkingLotService();
        this.scanner = new Scanner(System.in);
        this.intializationService = new IntializationService();
        this.intializationService.init();
    }

    public void start(){
        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(1);
        System.out.println("====================Welcome to " + parkingLot.getName() + " System!=====================");
        boolean exit = false;
        while(!exit)
        {
            printMenu();
            int choice = readInt();
            switch (choice){
                case 1:
                    handleGenrateTicket();
                    break;
                case 2:
                    genrateBill();
                    System.out.println("Thank you for using our parking lot system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("How can we assist you today?");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Exit Parking Lot");
        System.out.print("Enter your choice: ");
    }

    private int readInt(){
        while(!scanner.hasNextInt()){
            System.out.println("Please enter a valid number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void handleGenrateTicket() {
       try{
           System.out.println("Enter Vehicle Model Name:");
           String modelName = scanner.next();
           System.out.println("Enter Vehicle Number:");
           String vehicleNumber = scanner.next();
           System.out.println("Enter Vehicle Type (TWO_WHEELER,FOUR_WHEELER):");
           String typeInput = scanner.next().toUpperCase();
           VehicleType vehicleType = VehicleType.valueOf(typeInput);

            showParkingLotInfo();
            System.out.println("Enter Parking Lot ID from above List:");
            int parkingLotId = readInt();
            showGateInfo();
            System.out.println("Enter Parking Lot ID from above List:");
            int gateId = readInt();
            Vehicle vehicle = new Vehicle(modelName, vehicleNumber, vehicleType);
           Ticket ticket = parkingLotService.genrateTicket(vehicle,parkingLotId, gateId);
            System.out.println("Ticket generated successfully! Your ticket Details is:");
            ticket.showTicketDetails();

       }
       catch( IllegalArgumentException ex)
       {
           System.out.println("Invalid vehicle type. Please try again.");
       }
    }

    private void showParkingLotInfo() {
       System.out.println("Currently we have only one parking lot available havaing ID 1:");
    }

    private void showGateInfo() {
        System.out.println("Currently we have only two gates available having ID 1 and 2:");
    }

    private void genrateBill() {
       try{
              System.out.println("Enter Ticket ID:");
              int ticketId = readInt();
              showParkingLotInfo();
              System.out.println("Enter Parking Lot ID:");
              int parkingLotId = readInt();
              System.out.println("Enter Exit Gate ID:");
              int gateId = readInt();
              Bill bill = parkingLotService.genrateBill(ticketId, parkingLotId, gateId);
              System.out.println("Bill generated successfully! Your bill details is:");
              bill.showBillDetails();
         }
         catch(IllegalArgumentException ex)
         {
              System.out.println("Invalid input. Please try again.");
       }
    }

}
