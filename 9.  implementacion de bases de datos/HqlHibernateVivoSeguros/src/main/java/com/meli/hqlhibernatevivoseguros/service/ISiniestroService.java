package com.meli.hqlhibernatevivoseguros.service;

import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloListDTO;
import com.meli.hqlhibernatevivoseguros.dto.MatriculaMarcaModeloPerdidaListDTO;

public interface ISiniestroService {
    MatriculaMarcaModeloListDTO listarSiniestroMayorDeMilPesos();
    MatriculaMarcaModeloPerdidaListDTO listarSiniestroMayorDeMilPesosConPerdida();
}
