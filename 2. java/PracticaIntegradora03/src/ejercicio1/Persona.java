package ejercicio1;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public int calcularIMC() {

        double calculo = this.peso / (Math.pow(this.altura, 2)) - (this.peso + this.altura);
        if (calculo < 20) {
            return -1;
        } else if (calculo >= 20 && calculo <= 25) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean esMayordeEdad() {

        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
