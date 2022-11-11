package ej3;

public abstract class Animal {
    private String nombre;
    private float peso, edad;

    public Animal(String nombre, float peso, float edad) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
    }
    public abstract String hacerSonido();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEdad() {
        return edad;
    }

    public void setEdad(float edad) {
        this.edad = edad;
    }
}
