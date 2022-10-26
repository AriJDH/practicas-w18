package com.company;

import com.company.domain.Participante;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Participante> circuitoChico = new ArrayList<Participante>();
        List<Participante> circuitoMediano = new ArrayList<Participante>();
        List<Participante> circuitoGrande = new ArrayList<Participante>();
        UI ui = new UI(circuitoChico,circuitoMediano,circuitoGrande);
        ui.exec();
    }
}
