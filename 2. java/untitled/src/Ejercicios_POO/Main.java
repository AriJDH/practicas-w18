package Ejercicios_POO;

public class Main {
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Agustina", 26, "39177177");
        Persona persona3 = new Persona("Manuel", 35, "33177177", 88.8, 188.8);
        System.out.println(persona3.toString());
        System.out.println(persona2.toString());
        System.out.println(persona1.toString());
        persona1.mostrarPersona();
        persona2.mostrarPersona();
        persona3.mostrarPersona();
        int indice3 = persona3.calcularIMC();

        persona3.esMayorDeEdad();
    }
}
