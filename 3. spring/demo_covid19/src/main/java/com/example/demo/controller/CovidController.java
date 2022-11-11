package com.example.demo.controller;

import com.example.demo.DTO.Response.PersonaSintomaDTORes;
import com.example.demo.DTO.Response.SintomaDTORes;
import com.example.demo.Repository.RiskRepository;
import com.example.demo.Repository.SintomaRepository;
import com.example.demo.entity.PersonaSintomas;
import com.example.demo.entity.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    @GetMapping("/findSymptom")
    public SintomaDTORes findSymptom(){
        SintomaDTORes sintomaDTORes = new SintomaDTORes();
        SintomaRepository getSintomas = new SintomaRepository();

        sintomaDTORes.setSintomaList(getSintomas.getData());
        sintomaDTORes.setMessage("Todo Ok por acá");
        sintomaDTORes.setHttpStatus(HttpStatus.OK);

        return sintomaDTORes;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTORes> findSymptom(@PathVariable String name){
        SintomaDTORes sintomaDTORes = new SintomaDTORes();
        SintomaRepository getSintomas = new SintomaRepository();
        List<Sintoma> sintomaList = new ArrayList<>();
        sintomaList.add(getSintomas.getData(name));

        sintomaDTORes.setSintomaList(sintomaList);
        sintomaDTORes.setMessage("Todo Ok por acá");
        sintomaDTORes.setHttpStatus(HttpStatus.OK);

        return new ResponseEntity<>(sintomaDTORes,sintomaDTORes.getHttpStatus());
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaSintomaDTORes>> findRiskPerson(){

        List<PersonaSintomaDTORes> sintomaDTOResList = new ArrayList<>();

        //Obtiene datos aleatorios
        RiskRepository riskRepository = new RiskRepository();
        List<PersonaSintomas> personaSintomasList = riskRepository.getData();

        for (PersonaSintomas ps: personaSintomasList) {
            if (ps.getPersona().getEdad() > 60 && ps.getSintomaList().size() > 1) {
                PersonaSintomaDTORes sintomaDTORes = new PersonaSintomaDTORes();
                sintomaDTORes.setEdad(ps.getPersona().getEdad());
                sintomaDTORes.setFullNombre(ps.getPersona().getNombre() +" " +ps.getPersona().getApellido());
                List<String> listaSintomasPersona = new ArrayList<>();
                for (Sintoma s: ps.getSintomaList()) {
                    listaSintomasPersona.add(s.getNombre());
                }
                sintomaDTORes.setSintomas(listaSintomasPersona);
                sintomaDTORes.setMessage("Persona positiva para covid y en riesgo por edad");
                sintomaDTORes.setHttpStatus(HttpStatus.OK);
                sintomaDTOResList.add(sintomaDTORes);
            }
        }


        return new ResponseEntity<>(sintomaDTOResList,HttpStatus.OK);
    }
}
