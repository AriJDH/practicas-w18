package com.mercadolibre.miniseries.service;


import com.mercadolibre.miniseries.entity.Miniserie;
import com.mercadolibre.miniseries.repository.IMiniserieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MiniserieService implements IMiniserieService{
    private final IMiniserieRepository miniserieRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Miniserie> getMiniseries() {
        return miniserieRepository.findAll();
    }

    @Override
    public void saveMiniserie(Miniserie miniserie) {
        miniserieRepository.save(miniserie);
    }

    @Override
    public void deleteMiniserie(Long id) {
        miniserieRepository.deleteById(id);
    }

    @Override
    public Miniserie findMiniserie(Long id) {
        return miniserieRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public void updateMiniserie(Miniserie miniserieUpdated) {
        Miniserie miniserieToUpdate = this.findMiniserie(miniserieUpdated.getId());
        miniserieToUpdate.setName(miniserieUpdated.getName());
        miniserieToUpdate.setRating(miniserieUpdated.getRating());
        miniserieToUpdate.setAmountOfAwards(miniserieUpdated.getAmountOfAwards());
        miniserieRepository.save(miniserieToUpdate);
    }
}
