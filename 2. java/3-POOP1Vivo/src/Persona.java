public class Persona {

    // Atributos
    private String nombre;
    private String edad;
    private String dni;
    private Double peso;
    private Double altura;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    // Ejercicio 5 métodos calcularIMC - esMayorDeEdad
    public Double calcularIMC(){
        Double resultado = 0.0;
        Double calculoIMC = this.peso/(Math.pow(this.altura,2));
        if(calculoIMC <20.0){
            resultado = -1.00;
            System.out.println("Nivel de peso: bajo");
        } else if (calculoIMC >= 20 && calculoIMC<= 25) {
            resultado = 0.00;
            System.out.println("Nivel de peso: saludable. ");

        } else if (calculoIMC >25){
            resultado = 1.00;
            System.out.println("Nivel de peso: sobrepeso. ");

        } return resultado;
    }

    public Boolean esMayorDeEdad(){
        boolean resultado;
        if(Integer.parseInt(this.edad)>= 18 ){
            resultado = true;
        } else resultado = false;
        return resultado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
