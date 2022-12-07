package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.request.jerwelyCreateResponse;
import com.example.joyerialasperlas.model.Jewerly;
import com.example.joyerialasperlas.repository.IJewerlyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {

    private final IJewerlyRepository jewerlyRepository;

    public JewerlyService(IJewerlyRepository joyaRepository) {
        this.jewerlyRepository = joyaRepository;
    }

    @Override
    public List<Jewerly> obtenerJoyas() {
        List<Jewerly> jewerlyList = jewerlyRepository.findAll();
        return jewerlyList;
    }

    @Override
    public jerwelyCreateResponse guardarJoyas(Jewerly jewerly) {
        jewerlyRepository.save(jewerly);
        List<Jewerly> jewerlyList = jewerlyRepository.findAll();
        jewerlyList.sort(Comparator.comparing(Jewerly::getNroIdentificatorio).reversed());
        jerwelyCreateResponse response = new jerwelyCreateResponse();
        response.setMessage("Se ha creado el id "+jewerlyList.get(0).getNroIdentificatorio());
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public String borrarJoyas(Long idjewerly) {
        /*jewerlyRepository.deleteById(idjewerly);*/

        Jewerly joyaOriginal = this.encontrarJoya(idjewerly);
        joyaOriginal.setVentaONo(false);
        this.guardarJoyas(joyaOriginal);

        return "Joya con id " + idjewerly.toString() + " dada de baja para la venta correctamente";
    }


    @Override
    public Jewerly encontrarJoya(Long idjewerly) {
        Jewerly jewerlyReturn = jewerlyRepository.findById(idjewerly).orElse(null);
        return jewerlyReturn;
    }

    @Override
    public String editarJoya(Long idjewerly, Jewerly jewerly_upd) {
        Jewerly joyaOriginal = this.encontrarJoya(idjewerly);

        joyaOriginal.setNombre(jewerly_upd.getNombre());
        joyaOriginal.setMaterial(jewerly_upd.getMaterial());
        joyaOriginal.setPeso(jewerly_upd.getPeso());
        joyaOriginal.setParticularidad(jewerly_upd.getParticularidad());
        joyaOriginal.setPoseePiedra(jewerly_upd.getPoseePiedra());
        joyaOriginal.setVentaONo(jewerly_upd.getVentaONo());

        this.guardarJoyas(joyaOriginal);
        return "Modificaciones guardadas correctamente";
    }
}
