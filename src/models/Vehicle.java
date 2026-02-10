package models;

import models.constants.VehicleType;

public class Vehicle extends BaseModel {
    private String modelName;
    private  String vechileNumber;
    private VehicleType vehicleType;

    public Vehicle(String modelName, String vechileNumber, VehicleType vehicleType) {
        this.modelName = modelName;
        this.vechileNumber = vechileNumber;
        this.vehicleType = vehicleType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVechileNumber() {
        return vechileNumber;
    }

    public void setVechileNumber(String vechileNumber) {
        this.vechileNumber = vechileNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
