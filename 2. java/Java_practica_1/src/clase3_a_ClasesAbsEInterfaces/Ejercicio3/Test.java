package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        Animal animal = new Perro();

        gato.emitirSonidos();
        gato.comerCarne();
        animal.comer();
        animal = new Vaca();
        animal.comer();
    }
}
