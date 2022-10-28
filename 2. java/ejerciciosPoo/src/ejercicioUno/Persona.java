package ejercicioUno;

public class Persona {

    private String nombre;
    private int edad;
    private double peso;
    private String dni;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, double peso, String dni, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.dni = dni;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso / (Math.pow(this.altura,2));
        if(imc < 20){
            return -1;
        }else if(imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                '}';
    }
}
