package services.billingStrategy;

import models.Ticket;

public interface BillCalculationStrategy {
  long genrateBill(Ticket ticket, double OccupancyRatio );

}
