public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if(this.peso/(Math.pow(altura, 2)) < 20){
            return -1;
        } else if(this.peso/(Math.pow(altura, 2)) >= 20 && this.peso/(Math.pow(altura, 2)) <= 25) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Edad: " + this.edad + "\n" +
                "D.N.I: " + this.dni + "\n" +
                "Peso: " + this.peso + "\n" +
                "Altura: " + this.altura;
    }




}
