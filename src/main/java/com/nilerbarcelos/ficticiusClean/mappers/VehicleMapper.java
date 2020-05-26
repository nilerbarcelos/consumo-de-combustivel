package com.nilerbarcelos.ficticiusClean.mappers;

import com.nilerbarcelos.ficticiusClean.models.Vehicle;
import com.nilerbarcelos.ficticiusClean.dto.VehicleRequest;
import com.nilerbarcelos.ficticiusClean.dto.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleMapper {

    private Vehicle mapToEntity(VehicleRequest dto) {
        return new Vehicle(
                dto.getId(),
                dto.getName(),
                dto.getMake(),
                dto.getModel(),
                dto.getManufactureDate(),
                dto.getCityConsumption(),
                dto.getHighwayConsumption()
        );
    }

    private VehicleResponse mapToDto(Vehicle entity) {
        return new VehicleResponse(
                entity.getId(),
                entity.getName(),
                entity.getMake(),
                entity.getModel(),
                entity.getManufactureDate(),
                entity.getCityConsumption(),
                entity.getHighwayConsumption()
        );
    }

    private List<Vehicle> mapToListEntity(List<VehicleRequest> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    private List<VehicleResponse> mapToListDto(List<Vehicle> entities) {
        return entities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Vehicle toEntity(VehicleRequest dto) {
        return Optional.ofNullable(dto)
                .map(this::mapToEntity)
                .orElse(null);
    }

    public VehicleResponse toDto(Vehicle entity) {
        return Optional.ofNullable(entity)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<Vehicle> toListEntity(List<VehicleRequest> dtos) {
        return Optional.ofNullable(dtos)
                .map(this::mapToListEntity)
                .orElse(null);
    }

    public List<VehicleResponse> toListDto(List<Vehicle> entities) {
        return Optional.ofNullable(entities)
                .map(this::mapToListDto)
                .orElse(null);
    }
}
