package com.example.covid.Repository;

import com.example.covid.Entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RepositorySintomaImp implements IRepository<Sintoma> {

    private List<Sintoma> sintomaList;
    @Override
    public List<Sintoma> listarTodos() {
        return sintomaList;
    }

    public RepositorySintomaImp() {
        sintomaList = new ArrayList<>();
    }

    @Override
    public void agregar(Sintoma sintoma) {
        sintomaList.add(sintoma);
    }
}
