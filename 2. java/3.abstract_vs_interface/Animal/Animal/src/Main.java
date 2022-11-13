public class Main {
    public static void main(String[] args) {

        Perro perro1 = new Perro();
        perro1.comerAnimal(perro1);

        Gato ronnie = new Gato();
        ronnie.comerAnimal(ronnie);

        Vaca aurora = new Vaca();
        aurora.comerAnimal(aurora);
    }
}