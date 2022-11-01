package ClasesAbstractas_e_Interfaces.Ejercicio3;

import ClasesAbstractas_e_Interfaces.Ejercicio3.Animales.Gato;
import ClasesAbstractas_e_Interfaces.Ejercicio3.Animales.Perro;
import ClasesAbstractas_e_Interfaces.Ejercicio3.Animales.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        perro.comerAnimal(gato);
        gato.comerAnimal(perro);
    }
}
