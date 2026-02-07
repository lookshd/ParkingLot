package services.billingStrategy;

import models.Bill;
import models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
  Bill genrateBill(Ticket ticket);

}
