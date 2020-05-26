package com.nilerbarcelos.ficticiusClean.services;

public interface ConsumptionService {
    float computeTotalPrice(float fuelPrice, float consumedFuel);
    float computeUsage(float distance, float averageConsumption);
}
