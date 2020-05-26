package com.nilerbarcelos.ficticiusClean.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDate;
import java.util.UUID;

public class VehicleResponse implements Comparable {

    private final UUID id;
    private final String name;
    private final String make;
    private final String model;
    private final LocalDate manufactureDate;
    private final Float cityConsumption;
    private final Float highwayConsumption;
    @JsonInclude(Include.NON_NULL)
    private Float fuelConsumed;
    @JsonInclude(Include.NON_NULL)
    private Float total;

    public VehicleResponse(UUID id, String name, String make, String model, LocalDate manufactureDate,
                           Float cityConsumption, Float highwayConsumption) {
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

    public Float getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(Float fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public int compareTo(Object o) {
        VehicleResponse other = (VehicleResponse) o;
        if (other == null) return 0;
        if (this.getTotal() > other.getTotal()) {
            return 1;
        } else if (this.getTotal() < other.getTotal()) {
            return -1;
        }
        return 0;
    }
}
