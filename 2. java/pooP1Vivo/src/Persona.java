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

    public int calcularIMC(){
        float imc = (float) (this.peso /(Math.pow(this.altura,2)));
        int resultado;
        if (imc < 20){
            resultado = -1;
        } else if (imc>=20 && imc<=25){
            resultado = 0;
        } else{
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorEdad(){
        return edad>=18;
    }

    public String descripcionIMC(int imc){
        String mensaje;
        switch (imc){
            case 0:
                mensaje = "Peso saludable";
                break;
            case -1:
                mensaje = "Bajo peso";
                break;
            case 1:
                mensaje = "Sobrepeso";
                break;
            default:
                mensaje = "El valor ingresado es incorrecto";
        }
        return mensaje;
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
