package Ejercicio1;

public class Personal extends Persona {

    private String codigoInterno;

    public Personal(String nombre,
                    String apellido,
                    Integer dni,
                    String codigoInterno) {
        super(nombre, apellido, dni);
        this.codigoInterno = codigoInterno;
    }

    @Override
    public void anunciarse() {
        System.out.println("Soy un miembro del personal");
    }

    public void trabajar(){
        System.out.println("Estoy trabajando... ");
    }
}
