package com.bootcamp.joyeria.service.imp;

import com.bootcamp.joyeria.dto.req.GetReqDto;
import com.bootcamp.joyeria.dto.view.GemSaveView;
import com.bootcamp.joyeria.dto.view.GemView;
import com.bootcamp.joyeria.entity.Gem;
import com.bootcamp.joyeria.repository.IGemRepository;
import com.bootcamp.joyeria.service.IGemService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bootcamp.joyeria.util.Mapper.*;

@Service
public class GemService implements IGemService {

    private final IGemRepository repository;

    public GemService(IGemRepository repository) {
        this.repository = repository;
    }

    @Override
    public GemSaveView save(GetReqDto reqDto) {
        Gem gemResponse=repository.save(getGem(reqDto));
        GemSaveView saveView=new GemSaveView();
        saveView.setMessage("nro identificatorio: "+gemResponse.getId());
        return saveView;
    }

    @Override
    public List<GemView> findAll() {
        return getListGem(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repository.findById(id)
                .orElseThrow(()->new RuntimeException("id does not exist"))
                .setSaleOrNot(false);
    }

    @Override
    public GemView updateById(Long id,GetReqDto dto) {
        Gem gem=repository.findById(id)
                .orElseThrow(()->new RuntimeException("id does nor exist"));
        return getGemView(updater(gem,dto));
    }
    private Gem updater(Gem gem,GetReqDto dto){
        gem.setSaleOrNot(dto.getSaleOrNot());
        gem.setName(dto.getName());
        gem.setParticularity(dto.getParticularity());
        gem.setMaterial(dto.getMaterial());
        gem.setOwnsRock(dto.getOwnsRock());
        gem.setWeight(dto.getWeight());
        return gem;
    }
}
