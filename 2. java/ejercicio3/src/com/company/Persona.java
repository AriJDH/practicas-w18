package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0;
        this.altura = 0;
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
        int resultado = 0;
        double potencia = Math.pow(this.altura, 2);
        double result = this.peso / potencia - (this.peso + this.altura);
        if (result < 20) {
            resultado = -1;
        } else if (result >= 20 && result <= 25) {
            resultado = 0;
        } else {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad(int edad) {
        boolean mayor = false;
        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }

    public String toString() {
        String cadena = "Nombre: " + nombre + "Edad: " + edad + "DNI: " + dni + "Peso: " + peso + "Altura: " + altura;
        return cadena;

    }
}
