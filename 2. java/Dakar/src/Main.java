public class Main {
    public static void main(String[] args) {

        Vehiculo m1 = new Motos(200, 150, 92, "MBK930");
        Vehiculo a1 = new Autos(100, 100, 92, "MDK333");
        System.out.println(a1.getPatente());
        Carrera Circuito1 = new Carrera();
        Circuito1.setCantidadDeVehiculosPermitidos(5);
        Circuito1.darDeAltaAuto(200,100,300,"MDK333");
        Circuito1.darDeAltaMoto(100,100,92, "ABC123");
      Circuito1.mostrarVehiculos();

/*
  Circuito1.buscarVehiculoConPatente("MDK333");
        Circuito1.buscarVehiculoConPatente("MBK930");
        Circuito1.darDeAltaAuto(300, 200, 92, "123ABC");
        Circuito1.darDeAltaMoto(100,100,92,"ABC123");
        Circuito1.agregarVehiculo(a1);
        Circuito1.agregarVehiculo(m1);
        Circuito1.eliminarVehiculo(a1);
        Circuito1.ganadorCarrera(); */
    }
}

