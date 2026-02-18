package models;

import models.constants.VehicleType;

public class Vehicle extends BaseModel {
    private String modelName;
    private  String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(String modelName, String vechileNumber, VehicleType vehicleType) {
        this.modelName = modelName;
        this.vehicleNumber = vechileNumber;
        this.vehicleType = vehicleType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vechileNumber) {
        this.vehicleNumber = vechileNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
