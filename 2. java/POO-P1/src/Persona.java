/*
* Obs: Para mejorar esta version haria una clase CalculadoraIMC que tenga la responsabilidad de calcular y mostrar
* el mensaje correspondiente, ya que una Persona no deberia tener dicha responsabilidad.
* */


public class Persona {

    // Ejercicio 1
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    // Ejercicio 2
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

    //Ejercicio 5
    public String calcularIMC(){
        String mensaje="";
        int resultado=calcularIMCAuxiliar();
        if (resultado==-1)
            mensaje="Bajo peso";
        else {
            if (resultado == 0)
                mensaje="Peso saludable";
            else
                mensaje="Sobrepeso";
        }
        return mensaje;
    }
    private int calcularIMCAuxiliar(){
        int aRetornar=0;
        double imc=(peso/(Math.pow(altura,2)))-(peso+altura);
        if (imc<20)
            aRetornar=-1;
        else {
            if (imc>=20 && imc<=25)
                aRetornar=0;
            else
                aRetornar=1;
        }
        return aRetornar;
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    public String toString(){
        return "Nombre: "+nombre+", Dni: "+dni+", Edad: "+edad+", Peso: "+peso+", Altura: "+altura;
    }
}
