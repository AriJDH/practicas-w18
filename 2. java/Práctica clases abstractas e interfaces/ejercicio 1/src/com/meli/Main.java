package com.meli;

import com.meli.domain.Basic;

public class Main {

    public static void main(String[] args) {
        Basic marcos = new Basic("Marcos");
        marcos.confirmarPagoServicio();
        marcos.cancelarPagoServicio();
        marcos.confirmarConsultaSaldo();
        marcos.cancelarConsultaSaldo();
        marcos.confirmarRetiro();
        marcos.cancelarRetiro();
    }
}
