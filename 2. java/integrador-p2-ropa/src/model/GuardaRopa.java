package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int identificador = 0;
    private Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();


    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int saved = this.identificador;

        this.guardaRopa.put(this.getIdentificador(),listaDePrenda);

        setIdentificador(saved+1);
        return saved;
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaRopa.get(numero);
    }

    public void mostrarPrendas(){

        System.out.println("Le corresponde: " + getGuardaRopa());
    }



    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int id){
        this.identificador = id;
    }

    public Map<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }

    public void setGuardaRopa(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    @Override
    public String toString() {
        return "\nGuardaRopa{" +
                "Ultimo Numero identificador" + identificador +
                "\nGuardaRopa=" + guardaRopa +
                '}';
    }

}
