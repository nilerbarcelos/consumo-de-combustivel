package com.nilerbarcelos.ficticiusClean.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nilerbarcelos.ficticiusClean.models.Vehicle;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.Month;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleControllerTest {

    @Autowired
    private MockMvc mvc;

    private final int BAD_REQUEST_STATUS = 400;
    private final String VEHICLE_CONTEXT = "/vehicle";
    private final String VEHICLE_COMPUTE_CONTEXT = "/vehicle/compute";

    private static Vehicle vehicle;

    @BeforeClass
    public static void setup() {
        vehicle = new Vehicle();
        vehicle.setName("Sandero");
        vehicle.setMake("Renaul");
        vehicle.setMake("2017");
        LocalDate manufactureDate = LocalDate.of(2017, Month.JANUARY, 8);
        vehicle.setManufactureDate(manufactureDate);
        vehicle.setCityConsumption(15f);
        vehicle.setHighwayConsumption(20f);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void canPostVehicle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(VEHICLE_CONTEXT)
                .content("{\"name\":\"Sandero\",\"make\":\"Renault\",\"model\":\"2017\",\"manufactureDate\":\"2017-01-08\",\"cityConsumption\":5,\"highwayConsumption\":5}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sandero"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.make").value("Renault"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("2017"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufactureDate").value("2017-01-08"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityConsumption").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.highwayConsumption").value(5.0));
    }

    @Test
    public void canGetVehicleCompute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(VEHICLE_CONTEXT)
                .content("{\"name\":\"Sandero\",\"make\":\"Renault\",\"model\":\"2017\",\"manufactureDate\":\"2017-01-08\",\"cityConsumption\":5,\"highwayConsumption\":5}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

        mvc.perform(MockMvcRequestBuilders.get(VEHICLE_COMPUTE_CONTEXT)
                .param("price",  "5.0")
                .param("city", "10.0")
                .param("highway", "20.0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Sandero"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].make").value("Renault"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].model").value("2017"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].manufactureDate").value("2017-01-08"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cityConsumption").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].highwayConsumption").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fuelConsumed").value(6.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].total").value(30.0));

    }
}
