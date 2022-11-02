public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, double altura) {
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

    public String  getDni() {
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso/(Math.pow(this.altura, 2));
        int resultado;
        if(imc < 20){
            resultado = -1;
        }else if(imc >=20 && imc <=25){
            resultado = 0;
        }else{
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad(){
        if(this.edad > 18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona: \n" +
                "nombre=" + nombre + "\n" +
                "edad=" + edad + "\n" +
                "dni='" + dni + "\n" +
                "peso=" + peso + "\n" +
                "altura=" + altura;
    }
}
