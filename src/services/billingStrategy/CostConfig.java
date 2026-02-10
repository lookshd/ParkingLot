package services.billingStrategy;

import models.constants.VehicleType;

import java.util.HashMap;

public class CostConfig {
  public static   HashMap<VehicleType,Integer>initialHourCost;
  public static   HashMap<VehicleType,Integer>additionHourCost;
  public static final double SURGE_MULTIPLIER = 1.5;

    static {
      initialHourCostCost = new HashMap<>();
      initialHourCostCost.put(VehicleType.FOUR_WHEELER,50);
      initialHourCostCost.put(VehicleType.TWO_WHEELER,40);
      additionHourCost = new HashMap<>();
      additionHourCost.put(VehicleType.FOUR_WHEELER,30);
      additionHourCost.put(VehicleType.TWO_WHEELER,20);
  }

    

}
