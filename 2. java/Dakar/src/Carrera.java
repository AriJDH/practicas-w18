import java.util.List;

public class Carrera {
    double distasncia;
    double premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){

    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){

    }

    public void eliminarVehiculo(Vehiculo vehículo){

    }
    public void eliminarVehiculoConPatente(String unaPatente){

    }

    public Vehiculo determinarGanador(){
        Vehiculo winner= new Vehiculo();
        double win =0;
        for(Vehiculo v: this.vehiculos){
            if(win<(v.velocidad*v.aceleracion/2)/(v.anguloDeGiro*(v.peso-v.cantRueda*100))){
                win= (v.velocidad*v.aceleracion/2)/(v.anguloDeGiro*(v.peso-v.cantRueda*100));
                winner = v;
            }
        }
        return  winner;
    }

    public void socorrerAuto(String patente){

    }
    public void socorrerMoto(String patente){

    }

}
