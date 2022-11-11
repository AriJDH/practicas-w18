package com.augh.covid.controller;

import com.augh.covid.dto.response.PersonSymptomDTORes;
import com.augh.covid.dto.response.SymptomListDTORes;
import com.augh.covid.dto.response.SymptomSeverityDTORes;
import com.augh.covid.entity.Symptom;
import com.augh.covid.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CovidController {

    @GetMapping("/findSymptom")
    public ResponseEntity<SymptomListDTORes> getSymptoms() {
        return new ResponseEntity<>(
                new SymptomListDTORes(createSymptoms().stream().
                        map(Symptom::getName).
                        collect(Collectors.toList())),
                HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomSeverityDTORes> getPersonSymptoms(@PathVariable String name) {
        SymptomSeverityDTORes symptomSeverityDTORes = new SymptomSeverityDTORes();
        Optional<List<Symptom>> optionalSymptomList = createPersonSymptom().entrySet().stream().
                filter(personListEntry -> personListEntry.getKey().getFirstname().equals(name)).
                map(Map.Entry::getValue).
                findFirst();

        Map<String, String> symptomMap = new HashMap<>();
        if (optionalSymptomList.isPresent() && !optionalSymptomList.get().isEmpty()) {
            for (Symptom symptom : optionalSymptomList.get()) {
                symptomMap.put(symptom.getName(), symptom.getSeverity());
            }
            symptomSeverityDTORes.setSeverityNameMap(symptomMap);
        } else {
            symptomSeverityDTORes.setMessage("No symptoms found");
        }
        return new ResponseEntity<>(symptomSeverityDTORes, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonSymptomDTORes>> getNivelDeporte() {
        List<PersonSymptomDTORes> personSymptomDTOResList = new ArrayList<>();
        Map<Person, List<Symptom>> personSymptomMap = createPersonSymptom().entrySet().stream()
                .filter(personListEntry -> personListEntry.getKey().getAge() > 60 && !personListEntry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<Person, List<Symptom>> personSymptom : personSymptomMap.entrySet()) {
            PersonSymptomDTORes personSymptomDTORes = new PersonSymptomDTORes();

            personSymptomDTORes.setName(personSymptom.getKey().getFirstname() + " " + personSymptom.getKey().getLastname());
            personSymptomDTORes.setAge(personSymptom.getKey().getAge());

            Map<String, String> symptomMap = new HashMap<>();
            for (Symptom symptom : personSymptom.getValue()) {
                symptomMap.put(symptom.getName(), symptom.getSeverity());
            }
            personSymptomDTORes.setSeverityNameMap(symptomMap);

            personSymptomDTOResList.add(personSymptomDTORes);
        }
        return new ResponseEntity<>(personSymptomDTOResList, HttpStatus.OK);
    }

    private Map<Person, List<Symptom>> createPersonSymptom() {
        List<Person> personList = createPeople();
        List<Symptom> symptomList = createSymptoms();
        Map<Person, List<Symptom>> personSymptomMap = new HashMap<>();
        personSymptomMap.put(personList.get(0), new ArrayList<>(Arrays.asList(symptomList.get(5), symptomList.get(1))));
        personSymptomMap.put(personList.get(1), new ArrayList<>(Arrays.asList(symptomList.get(0))));
        personSymptomMap.put(personList.get(2), new ArrayList<>(Arrays.asList(symptomList.get(1), symptomList.get(2))));
        personSymptomMap.put(personList.get(3), new ArrayList<>(Arrays.asList(symptomList.get(0), symptomList.get(1), symptomList.get(2))));
        personSymptomMap.put(personList.get(4), new ArrayList<>(List.of()));
        return personSymptomMap;
    }

    private List<Person> createPeople() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(0L, "Yodel", "Ehihu", 2));
        personList.add(new Person(1L, "Bob", "Bobberton", 16));
        personList.add(new Person(2L, "Jenny", "Jennysville", 28));
        personList.add(new Person(3L, "Agnis", "Agnesia", 71));
        personList.add(new Person(4L, "Ludo", "Ludicrus", 43));
        return personList;
    }
    private List<Symptom> createSymptoms() {
        List<Symptom> symptomList = new ArrayList<>();
        symptomList.add(new Symptom(0L, "Bone hurt 💀", "Extreme"));
        symptomList.add(new Symptom(1L, "Cough", "Low"));
        symptomList.add(new Symptom(2L, "Fever", "High"));
        symptomList.add(new Symptom(3L, "Red eyes", "Medium"));
        symptomList.add(new Symptom(4L, "Breathing problems", "High"));
        symptomList.add(new Symptom(5L, "Stomach ache", "Medium"));
        return symptomList;
    }
}
