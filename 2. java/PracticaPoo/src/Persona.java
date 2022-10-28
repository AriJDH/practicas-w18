public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){};
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    };

    public Persona(String nombre,int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    };

    public int calcularIMC(){
        double calculo = this.peso/(Math.pow(this.altura,2));
        if(calculo <20)
            return -1;
        else if (calculo >=20 && calculo<26) {
            return 0;
        }else
            return 1;
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

    public boolean esMayorDeEdad(){
        if(this.edad > 17)
            return true;
        else return false;
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
}
