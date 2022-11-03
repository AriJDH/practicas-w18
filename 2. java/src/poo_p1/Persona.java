package poo_p1;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

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

    public double calcularMC() {
        double imc = peso / (Math.pow(altura, 2));

        if (imc < 20) {
            return -1;
        } else if (imc > 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean esMayorDeEdad() {
        return edad > 18;
    }

    @Override
    public String toString() {
        return
                "Nombre = '" + nombre +
                        ", Edad = " + edad +
                        ", Dni = " + dni +
                        ", Peso = " + peso +
                        ", Altura = " + altura;
    }

    public String getNombre() {
        return this.nombre;
    }
}
