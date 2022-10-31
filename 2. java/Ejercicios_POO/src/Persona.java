public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private int peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC(){
        double imc= this.peso/(this.altura * this.altura);
        double retorno;
        if (imc<20){
            retorno = -1;
        }else{
            if(imc >=20 && imc <= 25){
                retorno = 0;
            }else{
                retorno = 1;
            }
        }
        return retorno;
    }

    public boolean esMayorDeEdad(){
        boolean resultado = this.edad >= 18 ? true :  false;
        return resultado;
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
