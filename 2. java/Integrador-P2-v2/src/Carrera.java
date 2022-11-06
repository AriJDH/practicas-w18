import java.util.List;
import java.util.Optional;

public class Carrera{
    private Double distancia;
    private Double premioDolares;
    private String name;
    private int numeroVehiculos;
    private List<Vehiculo> vehiculos;

    private SocorrerAuto socorrerAuto=new SocorrerAuto();
    private SocorrerMoto socorrerMoto=new SocorrerMoto();

    public void darAltaAuto(Double vel,Double acel, Double anguloG, String patente,Double peso,int ruedas){
        Auto auto=new Auto(vel,acel,anguloG,patente,peso,ruedas);
        if (isCupo())
            vehiculos.add(auto);
    }

    public void darAltaMoto(Double vel,Double acel, Double anguloG, String patente,Double peso,int ruedas){
        Moto moto=new Moto(vel,acel,anguloG,patente,peso,ruedas);
        if (isCupo())
            vehiculos.add(moto);
    }

    private boolean isCupo(){
        return vehiculos.size()<=numeroVehiculos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> vehiculo=vehiculos.stream().filter(vehiculo1 -> vehiculo1.getPatente().equals(patente)).findFirst();
        vehiculo.ifPresent(vehiculos::remove);
    }

    public void ganadorCarrera(){
        vehiculos.stream().sorted((v1,v2)->v2.getMaxTot().compareTo(v1.getMaxTot()))
                .findFirst()
                .ifPresent(System.out::println);
    }
    private Vehiculo findByPatente(String patente){
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .get();
    }

    public void socorrerAuto(String patente){
        socorrerAuto.socorrerVehiculo((Auto) findByPatente(patente));
    };
    public void socorrerMoto(String patente){
        socorrerMoto.socorrerVehiculo((Moto) findByPatente(patente));
    };

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", name='" + name + '\'' +
                ", numeroVehiculos=" + numeroVehiculos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
