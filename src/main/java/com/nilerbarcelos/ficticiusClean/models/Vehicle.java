package com.nilerbarcelos.ficticiusClean.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "manufactureDate")
    private LocalDate manufactureDate;

    @Column(name = "cityConsumption")
    private BigDecimal cityConsumption;

    @Column(name = "highwayConsumption")
    private BigDecimal highwayConsumption;

    public Vehicle() {
    }

    public Vehicle(UUID id, String name, String make, String model,
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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public BigDecimal getCityConsumption() {
        return cityConsumption;
    }

    public void setCityConsumption(BigDecimal cityConsumption) {
        this.cityConsumption = cityConsumption;
    }

    public BigDecimal getHighwayConsumption() {
        return highwayConsumption;
    }

    public void setHighwayConsumption(BigDecimal highwayConsumption) {
        this.highwayConsumption = highwayConsumption;
    }
}
