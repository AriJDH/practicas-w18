package ejercicio_3;

public class Main {
    public static void main(String[] args) {
        Animal mushino = new Gato();
        Animal coco = new Perro();
        Animal betsy = new Vaca();

        mushino.emitirSonido();
        coco.emitirSonido();
        betsy.emitirSonido();

        ((Gato) mushino).comerCarne();
        ((Perro) coco).comerCarne();
        ((Vaca) betsy).comerHierba();

        Animal.comerAnimal(mushino);
        Animal.comerAnimal(coco);
        Animal.comerAnimal(betsy);


    }
}
