package repository;

import entity.Plato;

import java.util.List;

public interface IRepository {

    Plato consultarPlato(String nombre, Integer peso);
}