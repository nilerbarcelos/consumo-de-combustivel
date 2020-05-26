package com.nilerbarcelos.ficticiusClean.dto;

import java.time.LocalDate;
import java.util.UUID;

public class VehicleRequest {

    private final UUID id;
    private final String name;
    private final String make;
    private final String model;
    private final LocalDate manufactureDate;
    private final Float cityConsumption;
    private final Float highwayConsumption;

    public VehicleRequest(UUID id, String name, String make, String model,
                          LocalDate manufactureDate, Float cityConsumption, Float highwayConsumption) {
        this.id = id;
        this.name = name;
        this.make = make;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cityConsumption = cityConsumption;
        this.highwayConsumption = highwayConsumption;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public Float getCityConsumption() {
        return cityConsumption;
    }

    public Float getHighwayConsumption() {
        return highwayConsumption;
    }
}
