package repository;

import clases.Localizador;
import interfaces.IRepository;

import java.util.ArrayList;

public class LocalizadorRepository implements IRepository {
    private ArrayList<Localizador> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new ArrayList<>();
    }



    @Override
    public boolean create() {
        return false;
    }

    @Override
    public Object getById() {
        return null;
    }

    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}
