package com.company.domain;

public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;
    private int numeroParticipante;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo, int numeroParticipante) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroParticipante=numeroParticipante;
    }

    public void print(){
        System.out.println("Número de inscripción: "+ numeroParticipante);
        System.out.println("DNI: "+ dni);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Celular: "+celular);
        System.out.println("Número de emergencia: "+ numeroEmergencia);
        System.out.println("Grupo sanguíneo: "+grupoSanguineo);
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }
}
