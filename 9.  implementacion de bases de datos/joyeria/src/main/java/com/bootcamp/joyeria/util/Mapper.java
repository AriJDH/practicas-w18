package com.bootcamp.joyeria.util;



import com.bootcamp.joyeria.dto.req.GetReqDto;
import com.bootcamp.joyeria.dto.view.GemView;
import com.bootcamp.joyeria.entity.Gem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    private static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    public static Gem getGem(GetReqDto dto){
        return mapper.convertValue(dto,Gem.class);
    }
    public static GetReqDto getReqDto(Gem gem){
        return mapper.convertValue(gem, GetReqDto.class);
    }
    public static GemView getGemView(Gem gem){
        return mapper.convertValue(gem,GemView.class);
    }
    public static List<GemView> getListGem(List<Gem> gems){
        return gems.stream()
                .map(gem -> mapper.convertValue(gem,GemView.class))
                .collect(Collectors.toList());
    }
}
