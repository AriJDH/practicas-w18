package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {

    private static final List<String> subjectList = List.of("Maths", "English", "Science",
            "Biology", "Art", "Physical Education", "Computer Studies");

    public static List<SubjectDTO> generateRandomSubjectList() {
        Random rand = new Random();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(4); i++) {
            subjectDTOList.add(new SubjectDTO(
                    subjectList.get(rand.nextInt(subjectList.size())),
                    4.0 + rand.nextInt(6)));
        }
        return subjectDTOList;
    }

    public static List<SubjectDTO> generateFixedSubjectList1() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths", 9.5));
        subjectDTOList.add(new SubjectDTO("English", 6.7));
        subjectDTOList.add(new SubjectDTO("Science", 8.9));
        return subjectDTOList;
    }
}
