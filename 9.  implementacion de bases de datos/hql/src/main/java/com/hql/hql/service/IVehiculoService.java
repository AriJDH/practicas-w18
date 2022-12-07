package com.hql.hql.service;

import com.hql.hql.dto.*;

import java.util.List;

public interface IVehiculoService {
    public VehiculoDTO createVehiculo(VehiculoDTOReq vehiculoDTOReq);
    public List<VehiculoDTO> getAllVehiculos();
    public List<PatenteDTO> findPatentes();
    public List<AñoDTO> findByAñoDeFabricacion();
}
