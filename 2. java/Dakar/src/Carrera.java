import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();


    public void mostrarVehiculos(){
        System.out.println(listaVehiculos);
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos > listaVehiculos.size()) {
            Autos auto = new Autos(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
        } else {
            System.out.println("La carrera no admite mas vehiculos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos > listaVehiculos.size()) {
            Motos moto = new Motos(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        } else {
            System.out.println("La carrera no admite mas vehiculos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
        System.out.println("Vehiculo removido exitosamente.");
    }

    public void eliminarVehiculoConPantente(String patente) {
        for (Vehiculo veh : listaVehiculos
        ) {
            if (veh.getPatente().equals(patente)) {
                listaVehiculos.remove(veh);
            }
        }
    }

    public void buscarVehiculoConPatente(String patente) {
        for (Vehiculo veh : listaVehiculos
        ) {
            if (veh.getPatente().equals(patente)) {
                System.out.println("Patente" + veh.toString());
            }else {
                System.out.println("No se encontró su vehiculo.");
            }
            }

        }




        public void ganadorCarrera() {
            double aux = 0;
            String patente_Ganador = "";
            for (Vehiculo veh : listaVehiculos
            ) {

                double resultado = veh.getVelocidad() * (veh.getAceleracion() / 2) / (veh.getAnguloDeGiro() * (veh.getPeso() - veh.getRuedas() * 100));

                if (resultado > aux) {
                    aux = resultado;
                    patente_Ganador = veh.getPatente();
                }

            }

        }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}

