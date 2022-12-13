package com.vroom.autos.service;

import com.vroom.autos.dto.VehicleLicensePlateListResponse;
import com.vroom.autos.dto.VehicleLicensePlateMakeListResponse;
import com.vroom.autos.dto.VehicleLpMaMoListResponse;

public interface IVehicleService {
    VehicleLicensePlateListResponse getVehicleLicensePlateList();
    VehicleLicensePlateMakeListResponse getVehicleLicensePlateMakeListOrderByFabricationYear();
    VehicleLicensePlateListResponse getVehicleLicensePlateWhereWheelCountGreaterThanAndFabricationYearIs();
    VehicleLpMaMoListResponse getVehicleWhereAccidentMonetaryLossGreaterThan();
}
