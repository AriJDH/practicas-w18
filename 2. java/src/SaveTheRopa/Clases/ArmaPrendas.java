package SaveTheRopa.Clases;

import java.util.ArrayList;
import java.util.List;

public class ArmaPrendas extends Prenda {

    List<Prenda> listPrendas = new ArrayList<>();

    public ArmaPrendas(String marca, String modelo) {
        super(marca, modelo);
        listPrendas.add(new Prenda(marca, modelo) {
        });
    }

    public List<Prenda> getPrendas(){
        return listPrendas;
    }
}
