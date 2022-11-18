package ejercicio3.clases;

import ejercicio3.interfaces.AlimentableAnimal;
import ejercicio3.interfaces.AlimentableCarne;

public class Zorro extends Animal implements AlimentableAnimal, AlimentableCarne {

    public Zorro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Este animal se llama "+this.getNombre()+", es de tipo '"+getClass().getSimpleName()+"'\nSu sonido característico es ¡auuu!");
    }

}
