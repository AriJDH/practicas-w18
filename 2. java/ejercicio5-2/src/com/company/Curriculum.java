package com.company;

import org.w3c.dom.ls.LSOutput;

public class Curriculum extends Documento{
    Persona p = new Persona();

    public Curriculum() {
    }

    public Curriculum(Persona p) {
        this.p = p;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    @Override
    public void imprimible(String documento) {
        super.imprimible(documento);
        System.out.println(p.getNombre());
        System.out.println(p.getDni());
        System.out.println(p.getEdad());
        System.out.println(p.getHabilidades()); //seria con un for
    }
}
