public class Persona {
    private String Nombre;
    private int Edad;
    private String Dni;
    private int Peso;
    private int Altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        setNombre(nombre);
        setEdad(edad);
        setDni(dni);
    }


    public Persona(String nombre, int edad, String dni, int peso, int altura){
        setNombre(nombre);
        setEdad(edad);
        setDni(dni);
        setPeso(peso);
        setAltura(altura);
    }

    public int calcularIMC(){
        var calculo = getPeso()/(getAltura()*getAltura());
        if (calculo <20)
        {
            return -1;
        }else
            {
                if(calculo >= 20 && calculo <= 25){
                    return 0;
                }else{
                    return 1;
                }
            }
    }

    public boolean esMayorDeEdad(){
        boolean result = false;
        if(getEdad() >= 18){
            result = true;
        }
        return result;
    }

    @Override
    public String toString(){
        return "Paciente: "+getNombre() +
                " Edad: "+getEdad()+
                " Dni: "+getDni()+
                " Peso: "+getPeso()+
                " Altura: "+getAltura();
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public String getDni() {
        return Dni;
    }

    public int getPeso() {
        return Peso;
    }

    public int getAltura() {
        return Altura;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public void setAltura(int altura) {
        Altura = altura;
    }
}
