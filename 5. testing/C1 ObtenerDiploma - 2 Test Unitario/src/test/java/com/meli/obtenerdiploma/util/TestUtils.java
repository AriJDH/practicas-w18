package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/*https://docs.google.com/document/d/1zv7zulMMBNxx1f9C4y3UQDJTXD8rzdSD/edit*/

public class TestUtils {

    //Para definir el scope que tenemos en application.properties
    private static String SCOPE;

    private static ObjectWriter objectWriter;


    //EO1 - Test Unitarios Sin Mock - Cubrir comportamiento de la capa de repositorio
    //Cargamos un archivo vacío
    public static void emptyUsersFile() {
        /* Properties Class
        * Permite manipular archivos que almacenen de manera permanente una serie de valores emparejados cada uno de
        * ellos a un nombre, de manera similar a los nombres de variables que almacenan valores en memoria.
        * https://javiergarciaescobedo.es/programacion-en-java/15-ficheros/358-archivo-de-propiedades-properties
        * */
        Properties properties = new Properties();

        try {
            //carga el archivo application.properties
            properties.load(new ClassPathResource("application.properties").getInputStream());

            //obtenemos el valor test que es lo que seteamos en application.properties para test
            SCOPE = properties.getProperty("api.scope");

        } catch ( IOException e){
            e.printStackTrace();
        }

        PrintWriter writer = null;

        //Buscamos el archivo vacío
        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/"+ SCOPE + "/resources/usersEmpty.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //En el archivo referenciado escribimos un array vacío
        writer.println("[]");
        writer.close();
    }


    //EO1 - Test Unitarios Sin Mock - Cubrir comportamiento de la capa de repositorio
    public static StudentDTO saveStudentWith3Subjects(String name) {
        //Creo materias
        SubjectDTO subjectDTO1 = new SubjectDTO("Literatura", 9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Música", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Matemática", 8.0);

        //Creo lista de materias
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectDTO1);
        subjectDTOList.add(subjectDTO2);
        subjectDTOList.add(subjectDTO3);

        //Creo estudiante
        StudentDTO studentDTO = new StudentDTO(7L, name, subjectDTOList);

        return studentDTO;
    }

    public static Set<StudentDTO> getStudentSet() {
        //Creamos estudiantes
        StudentDTO studentDTO1 = saveStudentWith3Subjects("Juan");
        StudentDTO studentDTO2 = saveStudentWith3Subjects("Pedro");
/*        StudentDTO studentDTO3 = saveStudentWith3Subjects("Dani");
        StudentDTO studentDTO4 = saveStudentWith3Subjects("Nati");*/

/*        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(studentDTO1);
        studentDTOSet.add(studentDTO2);
        studentDTOSet.add(studentDTO3);
        studentDTOSet.add(studentDTO4);
        return studentDTOSet;*/

        return new HashSet<StudentDTO>(){
            {
                add(studentDTO1);
                add(studentDTO2);
              /*  add(studentDTO3);
                add(studentDTO4);*/
            }
        };

        }

    //EO1 - Test Unitarios Sin Mock - Cubrir comportamiento de la capa de repositorio
    //Cargamos un archivo con datos
    public static void usersFile() {
        Properties properties = new Properties();

        try {
            //carga el archivo application.properties
            properties.load(new ClassPathResource("application.properties").getInputStream());

            //obtenemos el valor test que es lo que seteamos en application.properties para test
            SCOPE = properties.getProperty("api.scope");

        } catch ( IOException e){
            e.printStackTrace();
        }

    }
    }

