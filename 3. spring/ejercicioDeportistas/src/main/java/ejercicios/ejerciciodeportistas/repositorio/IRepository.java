package ejercicios.ejerciciodeportistas.repositorio;

import ejercicios.ejerciciodeportistas.entidades.Sport;
import ejercicios.ejerciciodeportistas.entidades.SportPerson;

import java.util.List;

public interface IRepository {
    public List<Sport> findSports();
    public List<Sport> findSportByName(String name);
    public List<SportPerson> findSportsPersons();
}
