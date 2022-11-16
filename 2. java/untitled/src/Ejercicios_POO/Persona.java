package Ejercicios_POO;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public void mostrarPersona() {
        System.out.println("Hola me llamo " + this.nombre + ", mi edad es " + this.edad + " y mi dni " + this.dni);
    }

    public int calcularIMC() {
        double imc = (this.peso/Math.pow(this.altura,2)) - this.peso - this.altura/10;
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <=25) {
            return 0;
        } else { return 1; }
    }

    public boolean esMayorDeEdad() {
        if (this.edad >= 18) { return true; } else {return false;}
    }

}
