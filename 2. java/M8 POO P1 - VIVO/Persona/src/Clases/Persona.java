package Clases;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    //Constructors
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

    public Persona(String nombre) {
        //solución ejericio 4 - Creo constructor con parámetro nombre
        this.nombre = nombre;
    }

    //Getters and Setters
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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


    @Override
    public String toString() {
        return "Persona {\n"+
                "\tNombre: " + nombre + '\n' +
                "\tEdad: " + edad + '\n'+
                "\tDNI:' " + dni + '\n' +
                "\tPeso: " + peso + '\n' +
                "\tAltura: " + altura + '\n' +
                "\tNivel de Peso: " + imprimirNivelDePeso() +
                "\n}";
    }


    //Métodos
    public int calcularIMC(){
        double resultadoIMC = getPeso() / (Math.pow(getAltura(),2));
        int resultado = 0;


        if(resultadoIMC < 20){
            resultado = -1;
        } else if(resultadoIMC >= 20 && resultadoIMC <= 25){
            resultado =  0;
        } else {
            resultado = 1;
        }
        return resultado;
    }


    public boolean esMayorDeEdad(){
        return getEdad() >= 18;
    }

    public String imprimirNivelDePeso(){
        int resultadoIMC = this.calcularIMC();
        String mensaje= "";

        switch (resultadoIMC){
            case -1:
                mensaje = "Bajo de peso";
                break;
            case 0:
                mensaje = "Peso saludable";
                break;
            case 1:
                mensaje = "Sobrepeso";
                break;
            default:
                mensaje = "Datos de peso o altura ingresado incorrectamente";
        }
        return mensaje;
    }
}
