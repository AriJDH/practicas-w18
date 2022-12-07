package example.perlas.service;

import example.perlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoya();
    public  String  saveJoya (Joya joya);
    public void deleteJoya(long nroIdentificatorio);
    public Joya findJoya(long nroIdentificatorio);

    public String editJoya(Long id_modificar, Joya joya_modif);

}
