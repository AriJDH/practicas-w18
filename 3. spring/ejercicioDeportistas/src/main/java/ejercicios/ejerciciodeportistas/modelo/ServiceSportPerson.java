package ejercicios.ejerciciodeportistas.modelo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicios.ejerciciodeportistas.dto.response.SportDTOResponse;
import ejercicios.ejerciciodeportistas.dto.response.SportPersonDTOResponse;
import ejercicios.ejerciciodeportistas.repositorio.IRepository;
import ejercicios.ejerciciodeportistas.repositorio.RepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSportPerson {
    private final IRepository repository;
    private final ObjectMapper objectMapper;

    public ServiceSportPerson(RepositoryImp repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    public List<SportDTOResponse> findSports(){
        List<SportDTOResponse> sportListDTOResponses =  repository.findSports().stream()
                .map(sport -> objectMapper.convertValue(sport, SportDTOResponse.class))
                .collect(Collectors.toList());

        return sportListDTOResponses;
    }

    public List<SportDTOResponse> findSportsByName(String name){
        List<SportDTOResponse> sportListDTOResponses = repository.findSportByName(name)
                .stream()
                .map(sport -> objectMapper.convertValue(sport, SportDTOResponse.class))
                .collect(Collectors.toList());

        return sportListDTOResponses;
    }

    public List<SportPersonDTOResponse> findSportPersons(){
        List<SportPersonDTOResponse> sportPersonDTOResponses = repository.findSportsPersons().stream()
                .map(sportPerson -> objectMapper.convertValue(sportPerson, SportPersonDTOResponse.class))
                .collect(Collectors.toList());

        return sportPersonDTOResponses;
    }
}
