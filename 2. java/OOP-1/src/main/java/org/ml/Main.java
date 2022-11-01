package org.ml;

public class Main {
    public static void main(String[] args) {
        Persona daniel = new Persona("daniel", 25, "46545648", 1.80,80.0);

        String resultado;

        System.out.println("--------------------------------");
        System.out.println("Calculando IMC de la persona...");

        if (daniel.calcularIMC() == -1)
            resultado = "Bajo peso.";
        else if (daniel.calcularIMC() == 0)
            resultado = "Peso saludable.";
        else
            resultado = "Sobrepeso.";

        System.out.println("Su nivel de peso es: " + resultado);
        System.out.println(daniel.toString());

    }
}