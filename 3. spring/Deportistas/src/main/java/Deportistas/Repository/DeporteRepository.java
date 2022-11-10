package Deportistas.Repository;

import Deportistas.Entity.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository implements IRepository<Deporte>{

    private List<Deporte> deporteList;

    public DeporteRepository() {
        deporteList = new ArrayList<>();
    }

    @Override
    public List<Deporte> listarTodos() {
        return deporteList;
    }

    @Override
    public void agregar(Deporte deporte) {
        deporteList.add(deporte);
    }
}
