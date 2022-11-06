public class SocorrerAuto implements Socorrer<Auto>{
    @Override
    public void socorrerVehiculo(Auto auto) {
        System.out.println("Socorriente auto: "+auto.getPatente());
    }
}
