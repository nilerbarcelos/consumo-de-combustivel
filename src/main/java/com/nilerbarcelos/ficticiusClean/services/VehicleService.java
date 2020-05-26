package com.nilerbarcelos.ficticiusClean.services;

import com.nilerbarcelos.ficticiusClean.dto.VehicleResponse;
import com.nilerbarcelos.ficticiusClean.models.Vehicle;

import java.util.List;

public interface VehicleService {

    VehicleResponse insert(Vehicle vehicle);
    List<VehicleResponse> compute(float price, float city, float highway);
}
