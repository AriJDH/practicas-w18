package Impresora.Clases;

import Impresora.Interfaces.IImprimir;
import Impresora.Models.Informe;

public class Informes implements IImprimir<Informe> {
    public Informes(Informe informe) {
        setInforme(informe);
    }

    Informe informe;

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    @Override
    public void imprimir() {
        System.out.println(getInforme());
    }
}
