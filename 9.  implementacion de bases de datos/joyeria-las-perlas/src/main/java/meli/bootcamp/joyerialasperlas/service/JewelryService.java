package meli.bootcamp.joyerialasperlas.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import meli.bootcamp.joyerialasperlas.dto.req.JewelryDtoReq;
import meli.bootcamp.joyerialasperlas.dto.res.JewelrySavedDto;
import meli.bootcamp.joyerialasperlas.entity.Jewelry;
import meli.bootcamp.joyerialasperlas.repository.IJewelryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelryService implements IJewelryService{

    private final IJewelryRepository jewelryRepository;
    private final ObjectMapper mapper;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
        mapper = JsonMapper.builder()
                .findAndAddModules()
                .build()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    @Transactional
    public JewelrySavedDto saveJewelry(JewelryDtoReq jewelry) {
        Jewelry jewelryToSave = mapper.convertValue(jewelry, Jewelry.class);
        jewelryRepository.save(jewelryToSave);
        return new JewelrySavedDto("Se ha creado la joyeria satisfactoriamente",
                HttpStatus.OK.toString(), jewelryToSave.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewelry> getJewelry() {
        return jewelryRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteJewelry(Long id) {
        Jewelry jewelryToDelete = jewelryRepository.findById(id).orElse(null);
        if (jewelryToDelete != null) {
            jewelryToDelete.setOnSale(false);
            jewelryRepository.save(jewelryToDelete);
        }
        throw new IllegalStateException();
    }

    @Override
    @Transactional
    public JewelrySavedDto updateJewelry(Long id, JewelryDtoReq jewelry) {
         Jewelry jewelryToUpdate = jewelryRepository.findById(id).orElse(null);
         if (jewelryToUpdate != null) {
             jewelryToUpdate.setName(jewelry.getName());
             jewelryToUpdate.setMaterial(jewelry.getMaterial());
             jewelryToUpdate.setWeight(jewelry.getWeight());
             jewelryToUpdate.setNotes(jewelry.getNotes());
             jewelryToUpdate.setHasRocks(jewelry.getHasRocks());
             jewelryToUpdate.setOnSale(jewelry.getOnSale());
             jewelryRepository.save(jewelryToUpdate);
             return new JewelrySavedDto("Se ha actualizado la joyeria satisfactoriamente",
                     HttpStatus.OK.toString(), jewelryToUpdate.getId());
         }
         return null;
    }
}
