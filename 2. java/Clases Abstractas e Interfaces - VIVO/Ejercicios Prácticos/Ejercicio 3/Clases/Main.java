public class Main {

    public static void main(String[] args){

        //Casos de prueba
        Animal perro = new Perro();
        ComerAnimal.comerAnimal(perro);
        perro.hacerSonido();

        Animal gato = new Gato();
        ComerAnimal.comerAnimal(gato);
        gato.hacerSonido();

        Animal vaca = new Vaca();
        ComerAnimal.comerAnimal(vaca);
        vaca.hacerSonido();


    }

}
