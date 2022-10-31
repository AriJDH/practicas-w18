package InterfacesYClaseAbstractas.animales.clases;

import InterfacesYClaseAbstractas.animales.interfaces.Comestible;

public class Main {
    public static void main(String[] args) {
        Animales vaca = new Vaca(1.60, 500.00, "Normande");
        Comestible.comer(vaca);
        vaca.emitirSonido();
    }
}
