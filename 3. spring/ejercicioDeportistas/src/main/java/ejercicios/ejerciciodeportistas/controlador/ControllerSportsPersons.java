package ejercicios.ejerciciodeportistas.controlador;

import ejercicios.ejerciciodeportistas.dto.response.SportDTOResponse;
import ejercicios.ejerciciodeportistas.dto.response.SportPersonDTOResponse;
import ejercicios.ejerciciodeportistas.modelo.ServiceSportPerson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerSportsPersons {
    private ServiceSportPerson serviceSportPerson;

    public ControllerSportsPersons(ServiceSportPerson model) {
        this.serviceSportPerson = model;
    }

    @GetMapping( "/findSports")
    public List<SportDTOResponse> findSports(){
        return serviceSportPerson.findSports();
    }

    @GetMapping("/findSport/{name}")
    public List<SportDTOResponse> findSportsByName(@PathVariable String name){
        return serviceSportPerson.findSportsByName(name);
    }

    @GetMapping("findSportsPersons")
    public List<SportPersonDTOResponse> findSportsPersons(){
        return serviceSportPerson.findSportPersons();
    }
}
