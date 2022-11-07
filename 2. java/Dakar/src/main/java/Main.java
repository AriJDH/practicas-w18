public class Main {

    public static void main(String[] args) {


        Carrera carrera = new Carrera(100, 50000, "Gran Torino", 8);
        carrera.darDeAltaAuto(120, 20, 20, "ASD20");
        carrera.darDeAltaAuto(120, 20, 20, "ASD21");
        carrera.darDeAltaAuto(120, 30, 30, "ASD22");
        carrera.darDeAltaAuto(140, 20, 20, "ASD23");
        carrera.darDeAltaAuto(140, 50, 20, "ASD24");
        carrera.darDeAltaMoto(110, 50, 20, "FSD24");
        carrera.darDeAltaMoto(110, 70, 10, "FSD26");
        carrera.darDeAltaMoto(110, 20, 10, "FSD27");
        carrera.darDeAltaMoto(110, 10, 10, "FSD28");
        carrera.darDeAltaMoto(110, 10, 10, "FSD29");
        carrera.imprimirVehiculosEnCarrera();
        carrera.definirGanador();




    }



}
