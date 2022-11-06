public class SocorrerMoto implements Socorrer<Moto>{
    @Override
    public void socorrerVehiculo(Moto moto) {
        System.out.println("Socorriendo Moto: "+moto.getPatente());
    }
}
