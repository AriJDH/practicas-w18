package com.meli.lgutierrez.clase2.tarde;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente(){
        try{
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }else{
                int c = b / a;
            }
        }catch (Exception ex){
            System.out.println("Se ha producido un error: " + ex.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }



    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.calcularCociente();
    }
}
