package POO1P1Vivo;

// Ejercicio 1: Le asignaria String, int o float de acuerdo al dato, y todos privados para que solos se accedan desde
// la clase.
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

// Ejercicio 2:
// Constructor sin parametros
    public Persona(){
    }

// Constructor con 3 parametros nombre, edad y dni
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

// Constructor con 5 parametros, 2 mas que antes, son todos los datos.
    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
// Ejercicio 5: metodo
    public int calcularIMC(){
        float imc = (peso/(altura*altura));
        int resultado;
        if (imc < 20) {
            resultado = -1;
        } else if(imc >=20 && imc <= 25){
            resultado = 0;
        } else {
            resultado = 1;
        }
        return resultado;
    }

// Ejercicio 6: metodo para sber mayoria de edad
    public boolean esMayodDeEdad(){
        boolean mayoriaDeEdad = false;
        if (this.edad >= 18){
            mayoriaDeEdad = true;
        }
        return mayoriaDeEdad;
    }

// Mostramos todos los datos con ToString
    @Override
    public String toString() {
        return "Persona " +
                " cuyo nombre es " + nombre +
                "\n que tiene " + edad + "años" +
                "\n con dni: " + dni +
                "\n su altura es "+ altura + " m " +
                "\n y su peso es " + peso + "kg ";
    }
}
