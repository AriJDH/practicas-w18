package com.vroom.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleLpMaMoResponse {
    private String licensePlate;
    private String make;
    private String model;
}
