package com.mercadolibre.seguros.service;

import com.mercadolibre.seguros.entity.otros.PatenteMarca;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface IVehiculoService {
    List<String> getPatentes();
    List<HashMap<String, String>> getPatenteMarcaOrdenadosPorAnio();
}
