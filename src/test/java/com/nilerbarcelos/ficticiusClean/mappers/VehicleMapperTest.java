package com.nilerbarcelos.ficticiusClean.mappers;

import com.nilerbarcelos.ficticiusClean.dto.VehicleRequest;
import com.nilerbarcelos.ficticiusClean.dto.VehicleResponse;
import com.nilerbarcelos.ficticiusClean.models.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class VehicleMapperTest {

    private static final UUID ID = UUID.fromString("4eef4e4f-e70a-48b4-8621-1f40e611f88b");
    private static final String NAME = "Sandero";
    private static final String MAKE = "Renault";
    private static final String MODEL = "2017";
    private static final LocalDate MANUFACTURE_DATE = LocalDate.of(2020, 5, 25);
    private static final Float CITY_CONSUMPTION = 14.5f;
    private static final Float HIGHWAY_CONSUMPTION = 16.5f;

    private final VehicleMapper vehicleMapper = new VehicleMapper();

    @Test
    public void shouldMapToDto() {
        Vehicle entity = new Vehicle(
                ID,
                NAME,
                MAKE,
                MODEL,
                MANUFACTURE_DATE,
                CITY_CONSUMPTION,
                HIGHWAY_CONSUMPTION
        );

        VehicleResponse dto = vehicleMapper.toDto(entity);

        Assertions.assertEquals(ID, dto.getId());
        Assertions.assertEquals(NAME, dto.getName());
        Assertions.assertEquals(MAKE, dto.getMake());
        Assertions.assertEquals(MODEL, dto.getModel());
        Assertions.assertEquals(MANUFACTURE_DATE, dto.getManufactureDate());
        Assertions.assertEquals(CITY_CONSUMPTION, dto.getCityConsumption());
        Assertions.assertEquals(HIGHWAY_CONSUMPTION, dto.getHighwayConsumption());
    }

    @Test
    public void shouldMapToEntity() {
        VehicleRequest dto = new VehicleRequest(
                ID,
                NAME,
                MAKE,
                MODEL,
                MANUFACTURE_DATE,
                CITY_CONSUMPTION,
                HIGHWAY_CONSUMPTION
        );

        Vehicle entity = vehicleMapper.toEntity(dto);

        Assertions.assertEquals(ID, entity.getId());
        Assertions.assertEquals(NAME, entity.getName());
        Assertions.assertEquals(MAKE, entity.getMake());
        Assertions.assertEquals(MODEL, entity.getModel());
        Assertions.assertEquals(MANUFACTURE_DATE, entity.getManufactureDate());
        Assertions.assertEquals(CITY_CONSUMPTION, entity.getCityConsumption());
        Assertions.assertEquals(HIGHWAY_CONSUMPTION, entity.getHighwayConsumption());

    }

    @Test
    public void shouldMapToListDto() {
        List<Vehicle> entityList = Collections.singletonList(
                new Vehicle(
                        ID,
                        NAME,
                        MAKE,
                        MODEL,
                        MANUFACTURE_DATE,
                        CITY_CONSUMPTION,
                        HIGHWAY_CONSUMPTION
                )
        );

        List<VehicleResponse> dtoList = vehicleMapper.toListDto(entityList);

        Assertions.assertEquals(1, dtoList.size());
        VehicleResponse dto = dtoList.get(0);
        Assertions.assertEquals(ID, dto.getId());
        Assertions.assertEquals(NAME, dto.getName());
        Assertions.assertEquals(MAKE, dto.getMake());
        Assertions.assertEquals(MODEL, dto.getModel());
        Assertions.assertEquals(MANUFACTURE_DATE, dto.getManufactureDate());
        Assertions.assertEquals(CITY_CONSUMPTION, dto.getCityConsumption());
        Assertions.assertEquals(HIGHWAY_CONSUMPTION, dto.getHighwayConsumption());
    }

    @Test
    public void shouldMapToListEntity() {
        List<VehicleRequest> dtoList = Collections.singletonList(
                new VehicleRequest(
                        ID,
                        NAME,
                        MAKE,
                        MODEL,
                        MANUFACTURE_DATE,
                        CITY_CONSUMPTION,
                        HIGHWAY_CONSUMPTION
                )
        );

        List<Vehicle> entityList = vehicleMapper.toListEntity(dtoList);

        Assertions.assertEquals(1, entityList.size());
        Vehicle entity = entityList.get(0);
        Assertions.assertEquals(ID, entity.getId());
        Assertions.assertEquals(NAME, entity.getName());
        Assertions.assertEquals(MAKE, entity.getMake());
        Assertions.assertEquals(MODEL, entity.getModel());
        Assertions.assertEquals(MANUFACTURE_DATE, entity.getManufactureDate());
        Assertions.assertEquals(CITY_CONSUMPTION, entity.getCityConsumption());
        Assertions.assertEquals(HIGHWAY_CONSUMPTION, entity.getHighwayConsumption());
    }

    @Test
    public void toEntityWhenNull() {
        var entity = vehicleMapper.toEntity(null);

        Assertions.assertNull(entity);
    }

    @Test
    public void toDtoWhenNull() {
        var dto = vehicleMapper.toDto(null);

        Assertions.assertNull(dto);
    }

    @Test
    public void toListEntityWhenNull() {
        var entity = vehicleMapper.toListEntity(null);

        Assertions.assertNull(entity);
    }

    @Test
    public void toListDtoWhenNull() {
        var dto = vehicleMapper.toListDto(null);

        Assertions.assertNull(dto);
    }






























}
