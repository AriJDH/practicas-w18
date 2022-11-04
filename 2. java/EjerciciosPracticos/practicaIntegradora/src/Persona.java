//---------------------------- Ejercicio1 ----------------------------
public class Persona {
    //Variable de instancia
     private String nombre;
     private String edad;
     private String dni;
     private float peso;
     private double altura;

    //---------------------------- Ejercicio 2 - Constructores ----------------------------

    //---------------------------- Tipo 1 de persona:
    public Persona() {
    }

    // ---------------------------- Tipo 2 de persona
    public Persona(String nombre, String edad, String dni) {
       this.nombre = nombre;
       this.edad = edad;
       this.dni = dni;
    }

    // ----------------------------  Tipo 3 de persona
    public Persona(String nombre, String edad, String dni, float peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //---------------------------- Tipo 4 de persona

    public Persona(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //------------------------------ Getters- Setters ------------------------------

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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }


    //------------------------------Información de la persona ------------------------------

    @Override
    public String toString() {
        return
                "Nombre= " + nombre +
                ", Edad= " + edad +
                ", Dni= " + dni +
                ", Peso= " + peso +
                ", Altura =" + altura ;
    }


    //-------------------------Ejercicio 5 - Métodos---------------------------------

    // ----- Indice de masa corporal

    public int calcularIMC() {

        double imc = (peso / (Math.pow((altura) ,2)));
        int i=0;
        if (imc < 20) {
             i= (-1);
            System.out.println("El IMC es: "+ i);
            System.out.println("El nivel de peso es Bajo Peso");
        }
        if (20 <= imc && imc <= 25) {
            i= (0);
            System.out.println("El IMC es: "+ i);
            System.out.println("El nivel de peso es Peso Saludable");
        }
        if (imc>25){
            i= (1);
            System.out.println("El IMC es: "+ i);
            System.out.println("El nivel de peso es Sobrepeso");
        }

        return (i);
    }

    // ----- Mayor de edad
    public boolean esMayorDeEdad(){
        boolean r=false;
        if (Integer.parseInt(edad)>18){
            r = (true);
            System.out.println("La persona es mayor de edad.");
        }else {System.out.println("La persona es menor de edad.");}

        return (r);
    }

}
