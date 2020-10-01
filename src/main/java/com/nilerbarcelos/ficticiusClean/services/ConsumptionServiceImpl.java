package com.nilerbarcelos.ficticiusClean.services;

import org.springframework.stereotype.Service;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {
    @Override
    public BigDecimal computeTotalPrice(BigDecimal fuelPrice, BigDecimal consumedFuel) {
        return fuelPrice * consumedFuel;
    }

    @Override
    public BigDecimal computeUsage(BigDecimal distance, BigDecimal averageConsumption) {
        return distance / averageConsumption;
    }
}
