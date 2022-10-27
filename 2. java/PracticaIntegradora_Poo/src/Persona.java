public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = peso / Math.pow(altura,2);
        System.out.println(imc);

        int response = 1;

        if(imc < 20) {
            response = -1;
            System.out.println("Bajo peso");
        } else if(imc > 20 && imc <= 25){
            response = 0;
            System.out.println("Peso saludable");
        } else {
            response = 1;
            System.out.println("Sobrepeso");
        }

        return response;
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
