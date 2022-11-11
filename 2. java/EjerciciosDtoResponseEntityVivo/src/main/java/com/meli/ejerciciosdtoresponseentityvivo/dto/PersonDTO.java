package com.meli.ejerciciosdtoresponseentityvivo.dto;

public class PersonDTO {
    private String namePerson;
    private String lastnamePerson;
    private String nameSport;

    public PersonDTO(String namePerson, String lastnamePerson, String nameSport) {
        this.namePerson = namePerson;
        this.lastnamePerson = lastnamePerson;
        this.nameSport = nameSport;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getLastnamePerson() {
        return lastnamePerson;
    }

    public String getNameSport() {
        return nameSport;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setLastnamePerson(String lastnamePerson) {
        this.lastnamePerson = lastnamePerson;
    }

    public void setNameSport(String nameSport) {
        this.nameSport = nameSport;
    }
}
