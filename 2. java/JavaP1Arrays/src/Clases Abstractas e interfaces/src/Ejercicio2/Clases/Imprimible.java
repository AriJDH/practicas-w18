package Ejercicio2.Clases;

import Ejercicio2.Interfaces.IImprimir;
import Ejercicio2.Interfaces.IImprimirTodo;

public class Imprimible implements IImprimir, IImprimirTodo {
    private Curriculums curriculums;
    private Informes informes;
    private LibrosEnPdf librosEnPdf;

    public Imprimible(){
    }

    @Override
    public String toString() {
        return "Imprimible{" +
                "curriculums=" + curriculums +
                ", informes=" + informes +
                ", librosEnPdf=" + librosEnPdf +
                '}';
    }

    public Curriculums getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(Curriculums curriculums) {
        this.curriculums = curriculums;
    }

    public Informes getInformes() {
        return informes;
    }

    public void setInformes(Informes informes) {
        this.informes = informes;
    }

    public LibrosEnPdf getLibrosEnPdf() {
        return librosEnPdf;
    }

    public void setLibrosEnPdf(LibrosEnPdf librosEnPdf) {
        this.librosEnPdf = librosEnPdf;
    }

    @Override
    public void imprimir() {
        if (getCurriculums() instanceof Curriculums && (getCurriculums()).getPersona() != null) {
            System.out.println("Imprimiendo curriculum ...");
            getCurriculums().imprimir();
        }
        if (getInformes() instanceof Informes && (getInformes()).getInforme() != null) {
            System.out.println("Imprimiendo informe ...");
            getInformes().imprimir();
        }
        if (getLibrosEnPdf() instanceof LibrosEnPdf && (getLibrosEnPdf()).getLibro() != null) {
            System.out.println("Imprimiendo libro en formato PDF...");
            getLibrosEnPdf().imprimir();
        }

    }

    @Override
    public void imprimir(Object objeto) {
        setValues(objeto);

        if (getCurriculums() instanceof Curriculums && (getCurriculums()).getPersona() != null) {
            System.out.println("Imprimiendo curriculum ...");
            getCurriculums().imprimir();
        }
        if (getInformes() instanceof Informes && (getInformes()).getInforme() != null) {
            System.out.println("Imprimiendo informe ...");
            getInformes().imprimir();
        }
        if (getLibrosEnPdf() instanceof LibrosEnPdf && (getLibrosEnPdf()).getLibro() != null) {
            System.out.println("Imprimiendo libro en formato PDF...");
            getLibrosEnPdf().imprimir();
        }
    }

    private void setValues(Object objeto) {
        if (objeto != null && objeto instanceof Curriculums) {
            setCurriculums((Curriculums) objeto);
        }else{
            if (objeto != null && objeto instanceof Informes) {
                setInformes((Informes) objeto);
            }else{
                if (objeto != null && objeto instanceof LibrosEnPdf) {
                    setLibrosEnPdf ((LibrosEnPdf) objeto);
                }
            }
        }
    }
}
