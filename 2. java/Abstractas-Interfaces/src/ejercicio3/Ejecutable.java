package ejercicio3;

public class Ejecutable {

    public static void main(String[] args) {
        Animal perro = new Perro("Pipo");
        perro.comer();
        System.out.println(perro.emitirSonido());
    }
}
