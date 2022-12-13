package com.example.empresaseguro.service;

import com.example.empresaseguro.dto.request.VehiculoDTORequest;

public interface IServiceVehiculo {

    void crearVehiculo(VehiculoDTORequest vehiculoDTORequest);

    void findAll();

    void findById();

    // ------------------

    void findAllPlates(); // replace void with dto
    void findAllPlatesBrandOrderedByDate(); // replace void with dto
    void findAllPlatesMoreForWheelsAndThisYear(); // replace void with dto
    void findAllPlatesBrandModelWith10kLoss(); // replace void with dto
    void findAllPlatesBrandModelWith10kLossPlusTotal(); // replace void with dto




}


