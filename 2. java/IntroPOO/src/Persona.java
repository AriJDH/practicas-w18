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

    public int calcularIMC() {
        //peso/(altura^2) - (peso expresado en kg y altura en mts)
        float imc = (float) (this.peso/(Math.pow(this.altura,2)));
        if (imc<20) {
            return -1;
        }
        if (imc<=25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return  "Nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura;
    }
}
