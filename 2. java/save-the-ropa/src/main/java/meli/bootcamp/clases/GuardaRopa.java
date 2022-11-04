package meli.bootcamp.clases;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class GuardaRopa {
    private static int id = 0;
    private HashMap<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendra(List<Prenda> listaPrendas)
    {
        id++;
        prendas.put(id, listaPrendas);
        return id;
    }

    public void mostrarPrendas()
    {
        prendas.forEach( (x, y) ->
        {
            System.out.println("Key:" + x  + "Prendas:");
            System.out.print("\t");
            y.forEach(System.out::print);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        return prendas.get(numero);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GuardaRopa{");
        sb.append("prendas=").append(prendas);
        sb.append('}');
        return sb.toString();
    }
}
