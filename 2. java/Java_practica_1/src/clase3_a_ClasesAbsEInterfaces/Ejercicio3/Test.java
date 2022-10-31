package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonidos();
        gato.comerCarne();
        gato.comerAnimal(vaca);
    }
}
