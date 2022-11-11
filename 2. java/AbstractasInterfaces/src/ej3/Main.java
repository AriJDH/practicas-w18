package ej3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Freya", 13, 2, "Delac");
        Gato gato = new Gato("Navi", 2, 6, "Maine Coon");
        Vaca vaca = new Vaca("Mumu", 350, 14);

        System.out.println(perro.hacerSonido());
        System.out.println(gato.hacerSonido());
        System.out.println(vaca.hacerSonido());

        System.out.println(perro.comerCarne());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.comerHierba());

    }
}
