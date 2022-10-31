package com.meli.Documents;

public class Curriculum implements IPrint {
    private Person person;
    private static String TYPE_DOCUMENT= "Curriculum";

    public Curriculum(Person person) {
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println("Tipo de documento:" + TYPE_DOCUMENT);
        System.out.println("Detalle: " + this.person.toString());
    }

    @Override
    public String toString() {
        return "{" +
                "person=" + person +
                '}';
    }
}
