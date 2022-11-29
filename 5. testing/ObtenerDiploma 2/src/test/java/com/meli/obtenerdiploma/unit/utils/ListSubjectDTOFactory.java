package com.meli.obtenerdiploma.unit.utils;

import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class ListSubjectDTOFactory {
    public static List<SubjectDTO> utilNewListSubjectDtoAvg8(){
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática",10D);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física",8D);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química",6D);
        List<SubjectDTO> subjectDTOList = Arrays.asList(subjectDTO1, subjectDTO2, subjectDTO3);
        return subjectDTOList;
    }
}
