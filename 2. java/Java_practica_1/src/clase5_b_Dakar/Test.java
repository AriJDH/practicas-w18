package clase5_b_Dakar;

public class Test {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(200.0,10000.0,"Dakar 2022",10);
        carrera.darDeAltaAuto(100.0,50.0,30.0,"PRE123");
        carrera.darDeAltaAuto(300.0,30.0,31.0,"PRE200");
        carrera.darDeAltaAuto(140.0,40.0,32.0,"PRE412");
        carrera.darDeAltaAuto(12.0,34.0,34.0,"PRE984");
        carrera.darDeAltaAuto(130.0,29.0,50.0,"PRE983");
        carrera.darDeAltaMoto(200.0,100.0,40.0,"PRE980");
        carrera.darDeAltaMoto(300.0,30.0,31.0,"PRE201");
        carrera.ganadorCarrera();
        carrera.socorrerAuto("PRE123");
        carrera.socorrerMoto("PRE201");
    }
}
