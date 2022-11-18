package ejercicio3.clases;

import ejercicio3.interfaces.AlimentableCarne;

public class Perro extends Animal implements AlimentableCarne {


    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Este animal se llama "+this.getNombre()+", es de tipo '"+getClass().getSimpleName()+"'\nSu sonido característico es ¡guauuu!");
    }
}
