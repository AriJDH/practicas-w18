package com.example.covid.repositories;

public class RepositoryFactory {
    private static PersonaRepository personaRepository = null;
    private static SintomaRepository sintomaRepository = null;

    public static PersonaRepository getPersonaRepository(){
        if(personaRepository!=null)
                return personaRepository;
        else{
            personaRepository=new PersonaRepository();
            return personaRepository;
        }
    }

    public static SintomaRepository getSintomaRepository(){
        if(sintomaRepository!=null)
            return sintomaRepository;
        else{
            sintomaRepository=new SintomaRepository();
            return sintomaRepository;
        }
    }
}
