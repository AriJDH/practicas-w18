package ejercicio3.clases;

import ejercicio3.interfaces.AlimentableHierba;

public class Vaca extends Animal implements AlimentableHierba {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Este animal se llama "+this.getNombre()+", es de tipo '"+getClass().getSimpleName()+"'\nSu sonido característico es ¡muuu!");
    }
}
