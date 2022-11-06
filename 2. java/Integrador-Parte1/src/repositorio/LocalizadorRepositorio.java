package repositorio;

import model.Localizador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LocalizadorRepositorio implements Create<Localizador>{


    private List<Localizador>localizadors=new ArrayList<>();
    @Override
    public void create(Localizador localizador) {
        localizadors.add(localizador);
        System.out.println(localizador);
    }

    public void localizadoresVendidos(){
        System.out.println("Los localizadores vendidos fueron: "+localizadors.size());
    }
    public void totalReservas(){
        IntStream tReservas=localizadors.stream().mapToInt(localizadors->localizadors.getReservas().size());
        System.out.println("El total de reservas es de: "+tReservas.sum());

    }

}
