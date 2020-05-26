package com.nilerbarcelos.ficticiusClean.services;

import com.nilerbarcelos.ficticiusClean.dto.VehicleResponse;
import com.nilerbarcelos.ficticiusClean.mappers.VehicleMapper;
import com.nilerbarcelos.ficticiusClean.models.Vehicle;
import com.nilerbarcelos.ficticiusClean.repositories.VehicleRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceImplTest {

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ConsumptionService consumptionService;

    @Mock
    private VehicleMapper vehicleMapper;


    @Test
    public void testShouldInsertVehicle() {
        Vehicle vehicleMock = getVehicleEntity();
        VehicleResponse vehicleResponseMock = getVehicleResponse();
        Mockito.when(vehicleRepository.save(vehicleMock)).thenReturn(vehicleMock);
        Mockito.when(vehicleMapper.toDto(vehicleMock)).thenReturn(vehicleResponseMock);

        VehicleResponse vehicleResponse = vehicleService.insert(vehicleMock);

        Assert.assertEquals(vehicleMock.getId(), vehicleResponse.getId());
        Assert.assertEquals(vehicleMock.getName(), vehicleResponse.getName());
        Assert.assertEquals(vehicleMock.getMake(), vehicleResponse.getMake());
        Assert.assertEquals(vehicleMock.getModel(), vehicleResponse.getModel());
        Assert.assertEquals(vehicleMock.getManufactureDate(), vehicleResponse.getManufactureDate());
        Assert.assertEquals(vehicleMock.getHighwayConsumption(), vehicleResponse.getHighwayConsumption());
        Assert.assertEquals(vehicleMock.getCityConsumption(), vehicleResponse.getCityConsumption());
    }

    @Test
    public void testShouldComputeVehicles() {
        Vehicle vehicleMock = getVehicleEntity();
        VehicleResponse vehicleResponseMock = getVehicleResponse();
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(vehicleMock);
        Float highway = 20f;
        Float city = 15f;
        Float price = 5f;
        Mockito.when(vehicleRepository.save(vehicleMock)).thenReturn(vehicleMock);
        Mockito.when(vehicleMapper.toDto(vehicleMock)).thenReturn(vehicleResponseMock);
        Mockito.when(vehicleRepository.findAll()).thenReturn(allVehicles);
        Mockito.when(consumptionService.computeUsage(highway, vehicleMock.getHighwayConsumption())).thenReturn(4.0f);
        Mockito.when(consumptionService.computeUsage(city, vehicleMock.getCityConsumption())).thenReturn(3.0f);
        Mockito.when(consumptionService.computeTotalPrice(price, 7.0f)).thenReturn(35.0f);

        List<VehicleResponse> computedVehicles = vehicleService.compute(5.0f, 15f, 20f);

        Assert.assertEquals(1, computedVehicles.size());
        Assert.assertEquals(vehicleMock.getName(), computedVehicles.get(0).getName());
        Assert.assertEquals(vehicleMock.getMake(), computedVehicles.get(0).getMake());
        Assert.assertEquals(vehicleMock.getModel(), computedVehicles.get(0).getModel());
        Assert.assertEquals(vehicleMock.getManufactureDate(), computedVehicles.get(0).getManufactureDate());
        Assert.assertEquals(vehicleMock.getHighwayConsumption(), computedVehicles.get(0).getHighwayConsumption());
        Assert.assertEquals(vehicleMock.getCityConsumption(), computedVehicles.get(0).getCityConsumption());
        Assert.assertEquals(7.0f, computedVehicles.get(0).getFuelConsumed(), 0.0001);
        Assert.assertEquals(35.0f, computedVehicles.get(0).getTotal(), 0.0001);
    }

    private Vehicle getVehicleEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(UUID.fromString("4eef4e4f-e70a-48b4-8621-1f40e611f88b"));
        vehicle.setName("Sandero");
        vehicle.setMake("Renault");
        vehicle.setModel("2017");
        vehicle.setManufactureDate(LocalDate.of(2017, Month.JANUARY, 8));
        vehicle.setHighwayConsumption(5.0f);
        vehicle.setCityConsumption(5.0f);
        return vehicle;
    }

    private VehicleResponse getVehicleResponse() {
        VehicleResponse vehicle = new VehicleResponse(
                UUID.fromString("4eef4e4f-e70a-48b4-8621-1f40e611f88b"),
                "Sandero",
                "Renault",
                "2017",
                LocalDate.of(2017, Month.JANUARY, 8),
                5.0f,
                5.0f);

        return vehicle;
    }


}
