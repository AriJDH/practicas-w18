package com.youtuber.youtubeexcepciones.Repositorio;

import com.youtuber.youtubeexcepciones.exeptions.BlogNoEncontradoException;
import com.youtuber.youtubeexcepciones.exeptions.BlogRepetidoException;
import com.youtuber.youtubeexcepciones.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoEntrada implements IRepo{

    private HashMap<Integer, EntradaBlog> map = new HashMap<Integer, EntradaBlog>();

    @Override
    public EntradaBlog getEntradaBlog(int id) {
        if(map.get(id) == null)
            throw new BlogNoEncontradoException("No se encontro Blog con la id " + id);
        return map.get(id);
    }

    @Override
    public List<EntradaBlog> getAllEntradaBlogs() {
        List<EntradaBlog> lista = new ArrayList<>();
        for (Map.Entry<Integer, EntradaBlog> entry : map.entrySet()) {
            lista.add(map.get(entry.getKey()));
        }
        return lista;
    }

    @Override
    public void createEntradaBlog(EntradaBlog entrada) {

        if(map.get(entrada.getId()) != null)
            throw new BlogRepetidoException("Existe ya una entrada con la id " + entrada.getId());

        map.put(entrada.getId(), entrada);
    }
}
