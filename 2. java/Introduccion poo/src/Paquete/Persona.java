package Paquete;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;

//    Constructores
    public Persona(){
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        this.peso=peso;
        this.altura=altura;
    }

//    Métodos
    public int calcularIMC(){
      double imc = this.peso/(this.altura*this.altura);
      if (imc<20){
          return -1;
      } else {
          if(imc>=20 && imc<=25){
              return 0;
          }else {
              return 1;
          }
      }
    };

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    };

    public String toString(){
      return "DATOS PERSONA\n Nombre: " + this.nombre + "\n Edad: " + this.edad + "\n dni: " + this.dni + "\n Peso: " + this.peso + "\n Altura: "+ this.altura;
    };


//    Getters y setters
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
