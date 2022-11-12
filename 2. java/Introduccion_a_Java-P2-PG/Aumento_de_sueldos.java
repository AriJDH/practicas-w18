public class Aumento_de_sueldos {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoTope = 45000;
    double sueldoMinimo = 20000;
    double sueldoConAumento;
    double porcentajeAumento;

    public void calcularAumento() {

        // Tu codigo aqui
        if (sueldoBase <= sueldoMinimo) {
            porcentajeAumento = 0.20;
        }
        else if (sueldoBase > sueldoMinimo && sueldoBase <= sueldoTope) {
            porcentajeAumento = 0.10;
        }else if(sueldoBase > sueldoTope){
            porcentajeAumento = 0.05;
        }
        sueldoConAumento = sueldoBase + (sueldoBase * porcentajeAumento);

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Aumento_de_sueldos().calcularAumento();
    }

}