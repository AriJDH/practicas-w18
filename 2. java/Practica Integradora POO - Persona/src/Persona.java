public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    private double peso;
    private double altura;

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


    public double calcularIMC(){
        double calculo = 0;
        int imc = 0;

        calculo = this.peso/(Math.pow(this.altura, 2)) - (this.peso - this.altura);
        if(calculo < 20 ){
            imc = -1;
            System.out.println("Bajo Peso");
        }else if(calculo > 25){
            imc = 1;
            System.out.println("Sobrepeso");
        }else{
            System.out.println("Peso saludable");
        }
        return imc;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
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
