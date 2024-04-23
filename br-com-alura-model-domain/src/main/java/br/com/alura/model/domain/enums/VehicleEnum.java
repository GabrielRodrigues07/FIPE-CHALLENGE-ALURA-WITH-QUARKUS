package br.com.alura.model.domain.enums;

import java.util.List;

public enum VehicleEnum {
    CAR("carros"),
    MOTORCYCLE("motos"),
    TRUCK("caminhoes");

    private String vehicle;

    VehicleEnum(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public List<String> getVehicles() {
        return List.of(CAR.getVehicle(), TRUCK.getVehicle(), MOTORCYCLE.getVehicle());
    }
}
