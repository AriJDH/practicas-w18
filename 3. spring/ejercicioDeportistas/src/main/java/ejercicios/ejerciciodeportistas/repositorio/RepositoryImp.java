package ejercicios.ejerciciodeportistas.repositorio;

import ejercicios.ejerciciodeportistas.entidades.Sport;
import ejercicios.ejerciciodeportistas.entidades.SportPerson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryImp implements IRepository {
    ArrayList<SportPerson> listSportPeople = new ArrayList <>();
    ArrayList<Sport> listSports = new ArrayList <>();

    public RepositoryImp() {
        inicializarListaPersonas();
        inicializarDeportes();
    }

    private void inicializarListaPersonas(){
        listSportPeople.add(new SportPerson("Juan","Perez",32,"Atletismo"));
        listSportPeople.add(new SportPerson("Carlos","Restrepo",26,"Futbol"));
        listSportPeople.add(new SportPerson("Laura","Lopez",18,"Futbol"));
        listSportPeople.add(new SportPerson("Juan","Perez",29,"Atletismo"));
    }

    public void inicializarDeportes(){
        listSports.add(new Sport("Futbol","Amateur"));
        listSports.add(new Sport("Futbol","Profesional"));
        listSports.add(new Sport("Atletismo","Relevos"));
    }

    @Override
    public List<Sport> findSports() {
        return listSports;
    }

    @Override
    public List<Sport> findSportByName(String name) {
        return listSports.stream()
                .filter(sport -> sport.getNombre().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<SportPerson> findSportsPersons() {
        return listSportPeople;
    }
}
