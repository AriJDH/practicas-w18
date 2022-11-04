package Impresora.Models;

public class Habilidades {
    String HabilidadesBlandas;
    String HabilidadesDuras;

    @Override
    public String toString() {
        return "Habilidades{" +
                "Habilidades blandas='" + HabilidadesBlandas + '\'' +
                ", Habilidades duras='" + HabilidadesDuras + '\'' +
                '}';
    }

    public String getHabilidadesBlandas() {
        return HabilidadesBlandas;
    }

    public void setHabilidadesBlandas(String habilidadesBlandas) {
        HabilidadesBlandas = habilidadesBlandas;
    }

    public String getHabilidadesDuras() {
        return HabilidadesDuras;
    }

    public void setHabilidadesDuras(String habilidadesDuras) {
        HabilidadesDuras = habilidadesDuras;
    }
}
