package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository;

import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, R>{

    public void agregar(T objeto);
    public void mostrar();
    public void eliminar(R id);
    public Optional<T> buscar(R id);
}
