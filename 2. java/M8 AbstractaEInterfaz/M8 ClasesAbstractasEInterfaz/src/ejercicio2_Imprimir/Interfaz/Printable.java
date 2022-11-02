package ejercicio2_Imprimir.Interfaz;

public interface Printable <T> {
   static <T> void print(T document){
       System.out.println(document);
   }
}

