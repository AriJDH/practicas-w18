public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.getPeso() / Math.pow(this.getAltura(), 2);
        //System.out.println(imc);
        int res = 0;
        if (imc < 20) {
            res = -1;
        } else if (imc >= 20 && imc <= 25) {
            res = 0;
        } else {
            res = 1;
        }
        return res;
    }

    public void mostrarResultadoIMC(){
        switch (this.calcularIMC()){
            case -1:
                System.out.println("Bajo peso.");
                break;
            case 0:
                System.out.println("Peso saludable.");
            case 1:
                System.out.println("Sobreeso.");
                break;
        }
    }

    public void mostrarResultadoMayorDeEdad(){
        if(this.esMayorDeEdad()){
            System.out.println("Es mayor de edad.");
        }else{
            System.out.println("No es mayor de edad");
        }
    }

    public boolean esMayorDeEdad(){
        return this.getEdad() >= 18;
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
