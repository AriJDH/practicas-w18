package persona;

public class Persona {

    private String nombre;
    private int edad;
    private long dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, long dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, long dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = this.getPeso()/(this.getAltura() * this.getAltura());

        int saludable = 0;
        if (imc < 20) {
            saludable = -1;
        }

        if (imc > 25) {
            saludable = 1;
        }
        return saludable;
    }

    public boolean esMayorDeEdad() {
        return this.getEdad() >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
