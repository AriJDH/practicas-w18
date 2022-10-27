package ejercicio_practico_poo_p1;

public class Persona {

    private String nombre;

    private String edad;

    private String dni;

    private float peso;

    private float altura;

    public Persona() {
    }

    public Persona(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String edad, String dni, float peso, float altura) {
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int calcularIMC() {

        int retorno = 0;

        float imc = peso/(altura*altura);

        if (imc < 20) {
            retorno = -1;
        } else if (imc >= 20 && imc <= 25) {
            retorno = 0;
        } else {
            retorno = 1;
        }

        return retorno;
    }
}
