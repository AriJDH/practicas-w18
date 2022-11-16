package Ejercicio2ImprimirDocumentos.Documentos;

import Ejercicio2ImprimirDocumentos.Impresora.InterfazImprimible;

public class Curriculum implements InterfazImprimible {
    private Persona candidato;

    public Curriculum(Persona candidato) {
        this.candidato = candidato;
    }

    public Persona getCandidato() {
        return candidato;
    }

    public void setCandidato(Persona candidato) {
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return "Curriculum de " + candidato.getNombre() +" "+ candidato;
    }

}
