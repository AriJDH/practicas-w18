package service;

import dto.PlatoDTO;

public interface IServicePlato {

    PlatoDTO consultarPlato(String nombre, Integer peso);
}