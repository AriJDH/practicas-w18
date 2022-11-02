package com.meli.CourseSystem.Interfaces;

public interface IStudent {
    public default void toStudy(){
        System.out.println("Estudiando...");
    }
}
