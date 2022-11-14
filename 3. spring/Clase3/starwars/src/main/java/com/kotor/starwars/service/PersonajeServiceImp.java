package com.kotor.starwars.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotor.starwars.dto.response.PersonajeDTORes;
import com.kotor.starwars.entity.Personaje;
import com.kotor.starwars.repository.IPersonajeRepository;
import com.kotor.starwars.repository.PersonajeRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {

    private IPersonajeRepository personajeRepository = new PersonajeRepositoryImp();

    @Override
    public List<PersonajeDTORes> getPeople(String name) {
        List<Personaje> personList = personajeRepository.findByName(name);
        System.out.println(personList);

        ObjectMapper objectMapper = new ObjectMapper();
        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<PersonajeDTORes> personajeDTORes = personList.stream()
                .map(person -> objectMapper.convertValue(person, PersonajeDTORes.class))
                .collect(Collectors.toList());
        return personajeDTORes;
    }
}


//DESERIALIZAR UN ARCHIVO JSON PARA QUE RETORNE NULL SI ENCUENTRA UN TIPO DE DATO QUE NO COINCIDE CON EL DTO
/*      package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.entity;

        import com.fasterxml.jackson.core.JacksonException;
        import com.fasterxml.jackson.core.JsonGenerator;
        import com.fasterxml.jackson.core.JsonParser;
        import com.fasterxml.jackson.databind.DeserializationContext;
        import com.fasterxml.jackson.databind.JsonDeserializer;
        import com.fasterxml.jackson.databind.SerializerProvider;

        import java.io.IOException;

public class IntegerStringDeserialize extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        if (jsonParser.getText().equals("NA")
                || jsonParser.getText().contains(",")
                || jsonParser.getText().contains(".")) {
            return null;
        } else {
            return Integer.parseInt(jsonParser.getText());
        }
    }

    EN LA CLASE PERSONAJE

    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer height;

    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer mass;
}*/
