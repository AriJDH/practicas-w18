package Interfaces;

import Clases.Animal;

public interface comerHierba {
    public default String comerHierba(){
        return "Comiendo hierba";
    }
}
