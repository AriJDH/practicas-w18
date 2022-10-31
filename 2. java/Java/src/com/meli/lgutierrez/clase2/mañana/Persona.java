package com.meli.lgutierrez.clase2.mañana;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private float peso;
    private float altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float IMC = (this.peso / (this.altura/100 * this.altura/100));

        if (IMC < 20){
            return -1;
        }else if (IMC >= 20 && IMC <=25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorEdad(){
        if (this.edad >= 18){
            return true;
        } else {
            return false;
        }
    }

    public String mostrarPersona(){
        String imc = "";
        if (calcularIMC() == -1){
            imc = "Bajo peso";
        } else if (calcularIMC() == 0){
            imc = "Peso saludable";
        }else{
            imc = "Sobrepeso";
        }
        return "Índice de masa corporal (IMC): \t" + imc;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
