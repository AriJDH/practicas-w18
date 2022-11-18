package agencia_turismo.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListRepository <T> implements Repository<T>{
    protected List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public Optional<T> find(T t) {
        return list.stream().filter(o->o.equals(t)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public long count() {
        return list.size();
    }
}
