import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    // Atributos
    private Integer identificador = 0;
    private Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    // Constructores
    public GuardaRopa() {
    }

    public GuardaRopa(Integer identificador,
                      Map<Integer, List<Prenda>> guardaRopa) {
        this.identificador = identificador;
        this.guardaRopa = guardaRopa;
    }

    // Getters y setters
    public Integer getIdentificador() {
        return identificador;
    }

    public Map<Integer, List<Prenda>> getGuardaropas() {
        return guardaRopa;
    }

    // ---------------- Métodos ---------------- //
    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        identificador++;
        guardaRopa.put(identificador, listaDePrendas);
        System.out.println("El identificador es " + identificador);
        return identificador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> casillero : guardaRopa.entrySet()) {
            Integer clave = casillero.getKey();
            System.out.println("El casillero numero " + clave + " tiene las siguientes prendas: ");
            for (Prenda prenda : casillero.getValue())
                System.out.println(prenda.toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        System.out.println("El listado de prendas del numero " + numero + " es ");
        System.out.println(guardaRopa.get(numero));
        return guardaRopa.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "identificador=" + identificador +
                ", guardaRopa=" + guardaRopa +
                '}';
    }
}
