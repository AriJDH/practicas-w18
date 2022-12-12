package com.joyeria.joyeria.service;

import com.joyeria.joyeria.exception.JewerlyException;
import com.joyeria.joyeria.exception.NotFoundException;
import com.joyeria.joyeria.model.Jewerly;
import com.joyeria.joyeria.repository.IJewerlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewerlyService implements IJewerlyService {

    private final IJewerlyRepository jewerlyRepository;

    public JewerlyService(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }


    @Override
    public Jewerly save(Jewerly jewerly) {
        return jewerlyRepository.save(jewerly);
    }


    public List<Jewerly> getAll(){
        return jewerlyRepository.findAll();
    }

    @Override
    public List<Jewerly> getAllJewerliesOnSale() {
        //TODO No mostrar joyas con saleOrNot = false

        //Obtengo todas las joyas
        List<Jewerly> allJewerlies = jewerlyRepository.findAll();

        //Filtro las joyas que tiene saleOrNot = true
        List<Jewerly> jewerlyListSaleTrue = allJewerlies
                .stream()
                .filter(Jewerly::isSaleOrNot)
                .collect(Collectors.toList());

        return jewerlyListSaleTrue;
    }


    @Override
    public Jewerly findById(Long id) {
        return jewerlyRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("The jewerly with id " + id + " doesn't exist");
                });
    }

    @Override
    public Jewerly update(Long id, Jewerly jewerly) {
        jewerly.setId(id);
        return save(jewerly);

/*      Optional<Jewerly> jewerlyOptional = jewerlyRepository.findById(id);
        Jewerly jewerlyFounded = jewerlyOptional.get();

        jewerlyFounded.setId(id);
        jewerlyFounded = jewerlyRepository.save(jewerly);

        return jewerlyFounded;*/
    }

    @Override
    public void deleteLogicallyById(Long id) throws JewerlyException {

        Jewerly j = jewerlyRepository.findById(id)
                .orElseThrow(() -> new JewerlyException("The jewerly to remove can't be on sale"));

        if(j.getSaleOrNot()){
            j.setSaleOrNot(false);
        }

        jewerlyRepository.saveAndFlush(j);

    }
}
