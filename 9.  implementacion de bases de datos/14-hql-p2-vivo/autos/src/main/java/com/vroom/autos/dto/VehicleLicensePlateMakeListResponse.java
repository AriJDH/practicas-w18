package com.vroom.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleLicensePlateMakeListResponse {
    List<VehicleLicensePlateMakeResponse> vehicleLicensePlateMakeResponseList;
}
