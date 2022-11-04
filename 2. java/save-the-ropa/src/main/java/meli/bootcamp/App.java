package meli.bootcamp;

import meli.bootcamp.clases.GuardaRopa;
import meli.bootcamp.clases.Prenda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Prenda> prendaList = new ArrayList<>();
        Prenda p = new Prenda("A", "b");
        Prenda p2 = new Prenda("C", "D");
        prendaList.add(p);
        prendaList.add(p2);
        GuardaRopa guard = new GuardaRopa();
        guard.guardarPrendra(prendaList);
        guard.mostrarPrendas();
        List<Prenda> a = guard.devolverPrendas(1);
        System.out.println();
        System.out.println(a.size());
    }
}
