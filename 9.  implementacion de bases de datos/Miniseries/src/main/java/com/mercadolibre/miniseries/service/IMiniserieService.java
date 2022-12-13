package com.mercadolibre.miniseries.service;

import com.mercadolibre.miniseries.entity.Miniserie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMiniserieService {
    List<Miniserie> getMiniseries();
    void saveMiniserie(Miniserie miniserie);
    void deleteMiniserie(Long id);
    Miniserie findMiniserie(Long id);
    void updateMiniserie(Miniserie miniserie);

}
