package services.billingStrategy;

import models.Ticket;
import models.constants.VehicleType;

import java.time.LocalDateTime;

// we have ticket ticket contain vechicle type and entry time and parking spot
public class simpleBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public long genrateBill(Ticket ticket, double OccupancyRatio)
    {

        LocalDateTime exitTime = LocalDateTime.now();
        LocalDateTime entryTime= ticket.getEntryTime();
        VehicleType vehicleType= ticket.getVehicle().getVehicleType();
        long totalMinutes =
                java.time.temporal.ChronoUnit.MINUTES.between(entryTime, exitTime);
        long billableHours = 1;
        long remainingMinutes = Math.max(0, totalMinutes - 60);
        billableHours += (long) Math.ceil(remainingMinutes / 60.0);
        long intitialCost = CostConfig.initialHourCost.get(ticket.getVehicle().getVehicleType());
        long additionalCost = CostConfig.additionHourCost.get((ticket.getVehicle().getVehicleType()))*(billableHours-1);
        return intitialCost + additionalCost;
    };

}
