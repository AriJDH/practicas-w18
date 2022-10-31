package Prueba;

import java.util.LinkedList;
import java.util.List;

public class Prueba {
    List<String> mensajeStrings = new LinkedList<String>();
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";

    int[] numeros = new int[5];

    public void asignarValor() {
        //Código que arroja excepción, escribi tu codigo aqui
        try{
            numeros[5] = 10;
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args){
        Prueba prueba = new Prueba();
        prueba.imprimirMensaje(prueba.mensajeFinal);
        prueba.asignarValor();
    }
}
