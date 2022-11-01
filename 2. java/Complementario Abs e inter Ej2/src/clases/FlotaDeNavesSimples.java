package clases;

public class FlotaDeNavesSimples extends Nave {

    private String nombre;
    private NaveSimple naves[];

    public FlotaDeNavesSimples(String nombre) {
        super(nombre);
        setNaves(nombre);

    }

    private void setNaves(String nombre){
        this.naves = new NaveSimple[4];
        for(int i = 0; i < 4; i++){
            this.naves[i] = new NaveSimple(nombre  +" "+ (i+1));
        }
    }

    @Override
    public double mover(double x, double y) {
        double distanciaPromedio = 0;
        for(int i = 0; i < this.naves.length; i++){
            distanciaPromedio += this.naves[i].mover(x, y);
        }
        distanciaPromedio = distanciaPromedio / this.naves.length;

        return distanciaPromedio;
    }
}
