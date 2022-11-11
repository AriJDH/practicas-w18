package Exepciones1;

import java.util.LinkedList;
import java.util.List;

public class main {
    static String mensajeFinal = "Este es el último mensaje";
    public static void main (String[] args){

        //Mensaje final

        asignarValor();
    }
    public static void asignarValor() {
        int[] numeros = new int[5];
        try{
            numeros[5] = 10;
        }
        catch(Exception ex){
            imprimirMensaje(ex.getMessage());
        }
        finally{
            imprimirMensaje(mensajeFinal);
        }

    }
    private static void imprimirMensaje(String mensaje) {
        List<String> mensajeStrings = new LinkedList<>();
        System.out.println(mensaje);
    }
}
