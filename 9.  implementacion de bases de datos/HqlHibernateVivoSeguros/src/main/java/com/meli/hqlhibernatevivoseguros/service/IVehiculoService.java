package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.PatenteListDTO;
import com.meli.hqlhibernatevivoseguros.dto.PatenteMarcaListDTO;

public interface IVehiculoService {
    PatenteListDTO listarPatentes();
    PatenteMarcaListDTO listarPatenteMarcaOrderByAnioFabricacion();
    PatenteListDTO listarPatentesVehiculosCuatroRuedasFabricadosAnioActual();
}
