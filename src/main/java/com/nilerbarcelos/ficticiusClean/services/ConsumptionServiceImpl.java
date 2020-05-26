package com.nilerbarcelos.ficticiusClean.services;

import org.springframework.stereotype.Service;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {
    @Override
    public float computeTotalPrice(float fuelPrice, float consumedFuel) {
        return fuelPrice * consumedFuel;
    }

    @Override
    public float computeUsage(float distance, float averageConsumption) {
        return distance / averageConsumption;
    }
}
