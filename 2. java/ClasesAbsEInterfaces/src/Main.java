import Ejercicio2.Curriculums;
import Ejercicio2.Documento;
import Ejercicio2.LibroPDF;
import Ejercicio3.Animal;
import Ejercicio3.Perro;
import Ejercicio3.Vaca;

public class Main {
    public static void main(String[] args) {
        // EJERCICIO 2
        Curriculums curriculum = new Curriculums("Lucas", "Padula",24, "programador");
        LibroPDF libro = new LibroPDF(100, "Lucas", "Java 2", "Terror");

        Documento.imprime(curriculum);
        Documento.imprime(libro);

        // EJERCICIO 3
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        vaca.emitirSonido();

        perro.comerAnimal();
        vaca.comerAnimal();
    }
}