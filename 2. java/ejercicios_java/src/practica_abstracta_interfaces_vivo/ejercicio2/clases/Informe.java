package practica_abstracta_interfaces_vivo.ejercicio2.clases;

import practica_abstracta_interfaces_vivo.ejercicio2.interfaces.IImpresion;

public class Informe implements IImpresion {

    @Override
    public void imprimirDocumento(String tipoDocumento) {
        System.out.println("Se imprime " + tipoDocumento);
    }
}
