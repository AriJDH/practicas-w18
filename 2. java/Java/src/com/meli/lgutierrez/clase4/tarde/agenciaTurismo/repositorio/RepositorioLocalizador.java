package com.meli.lgutierrez.clase4.tarde.agenciaTurismo.repositorio;

import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.Localizador;
import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.Reserva;

public class RepositorioLocalizador {

    public void agregarReserva(Localizador localizador, Reserva reserva){
        localizador.getReservas().add(reserva);
    }
}
