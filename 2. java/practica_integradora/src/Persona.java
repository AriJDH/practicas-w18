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


    public double cacularIMC(){

       double indiceMasaCorporal =Math.pow(this.altura, 2);

       if (indiceMasaCorporal < 20) {

           return -1;

       }else if(indiceMasaCorporal > 20 && indiceMasaCorporal < 25){

           return 0;

       } else if (indiceMasaCorporal > 25){

           return 1;

       }

       return indiceMasaCorporal;
    }

    public boolean esMayorDeEdad(){

        if(edad >= 18){

            return true;

        } else {

            return false;

        }

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

