package Ejercicio3.Clases;

public class Main {
    public static void main(String[] args) {
        Animal gato = new Gato();
        //gato.sonido();

        Animal perro = new Perro();
        //perro.sonido();

        Animal vaca = new Vaca();
        //vaca.sonido();

        Main main = new Main();
        main.comerAnimal(gato);
        main.comerAnimal(perro);
        main.comerAnimal(vaca);
    }

    public void comerAnimal(Object objeto){
        if (objeto != null && objeto instanceof Perro) {
            ((Perro) objeto).comerCarne();
        }else{
            if (objeto != null && objeto instanceof Gato) {
                ((Gato) objeto).comerCarne();
            }else{
                if (objeto != null && objeto instanceof Vaca) {
                    ((Vaca) objeto).comerHierba();
                }
            }
        }
    }
}
