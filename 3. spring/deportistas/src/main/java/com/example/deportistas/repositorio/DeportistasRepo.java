package com.example.deportistas.repositorio;

import com.example.deportistas.entity.Deportista;

import java.util.ArrayList;
import java.util.List;

public abstract class DeportistasRepo {
 public static List<Deportista> lista = new ArrayList<>();
    static{
        lista.add(new Deportista("Gabriel","Guerra",38, DeportesRepo.lista.get(0)));
        lista.add(new Deportista("Gabriela","Ortega",40, DeportesRepo.lista.get(2)));
        lista.add(new Deportista("Laura","Gutierrez",29, DeportesRepo.lista.get(0)));
    }
}
