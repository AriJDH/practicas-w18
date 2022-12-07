package example.perlas.service;

import example.perlas.model.Joya;
import example.perlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoya() {
        List<Joya> joyaList =joyaRepository.findAll();
        return joyaList;
    }

    @Override
    public String saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return "Joya almacenada.";

    }



    @Override
    public void deleteJoya(long nroIdentificatorio) {
        joyaRepository.deleteAllById(Collections.singleton(nroIdentificatorio));

    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(long nroIdentificatorio) {
        Joya joy=joyaRepository.findById(nroIdentificatorio).orElse(null);
        return joy;
    }
    @Override
    public String editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVenta(joya_modif.isVenta());

        this.saveJoya(joyaOriginal);
        return "Modificaciones guardadas correctamente";

    }
}
