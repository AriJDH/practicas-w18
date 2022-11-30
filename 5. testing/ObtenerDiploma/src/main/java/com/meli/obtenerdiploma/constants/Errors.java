package com.meli.obtenerdiploma.constants;

public class Errors {

    //Student
    public final static String EMPTY_NAME_STU = "El nombre del alumno no puede estar vacío.";
    public final static String STU_NAME_ERR = "El nombre del alumno debe comenzar con mayúscula.";
    public final static String STU_NAME_SIZE_ERR = "La longitud del nombre no puede superar los 50 caracteres.";
    public final static String EMPTY_LIST = "La lista no puede ser vacía.";

    //Subject
    public final static String EMPTY_NAME_SUB = "El nombre de la materia no puede estar vacío.";
    public final static String SUB_NAME_ERR = "El nombre de la materia debe comenzar con mayúscula.";
    public final static String SUB_NAME_SIZE_ERR = "La longitud del nombre no puede superar los 30 caracteres.";
    public final static String SUB_SCORE_NULL = "La nota no puede estar vacía.";
    public final static String SUB_SCORE_MIN_ERR = "La mínima nota es 0.0.";
    public final static String SUB_SCORE_MAX_ERR = "La máxima nota es 10.0.";

}
