package com.nilerbarcelos.ficticiusClean.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsumptionServiceImplTest {

    private static final Float FUEL_PRICE = 3.5f;
    private static final Float CONSUMED_FUEL = 11.5f;
    private static final Float DISTANCE = 50f;
    private static final Float AVERAGE_CONSUMPTION = 17.5f;

    private final ConsumptionService consumptionService = new ConsumptionServiceImpl();

    @Test
    public void shouldComputeTotalPrice() {
        Float totalPrice = consumptionService.computeTotalPrice(FUEL_PRICE, CONSUMED_FUEL);

        Assertions.assertEquals(40.25f, totalPrice);
    }

    @Test
    public void shouldComputeUsage() {
        Float usage = consumptionService.computeUsage(DISTANCE, AVERAGE_CONSUMPTION);

        Assertions.assertEquals(2.857143f, usage);
    }
}
