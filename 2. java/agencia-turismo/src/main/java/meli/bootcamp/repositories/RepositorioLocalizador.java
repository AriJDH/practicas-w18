package meli.bootcamp.repositories;

import meli.bootcamp.clases.Localizador;

public class RepositorioLocalizador {

    public void mostrarDetallesCompra(Localizador localizador)
    {
        System.out.println(localizador);
    }
    public void saveLocalizador(Localizador localizador) {
        System.out.println("LOCALIZADOR ALMACENADO");
    }
}
