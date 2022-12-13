package com.vroom.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleLicensePlateMakeResponse {
    String licensePlate;
    String make;
}
