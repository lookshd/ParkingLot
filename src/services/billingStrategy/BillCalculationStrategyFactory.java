package services.billingStrategy;
public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculation(BillCalculationStrategies billCalculationStrategy){
        return new simpleBillCalculationStrategy();

    }

}
