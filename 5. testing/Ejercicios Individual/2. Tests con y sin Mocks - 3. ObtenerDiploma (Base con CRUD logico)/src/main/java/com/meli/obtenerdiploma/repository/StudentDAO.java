package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO {
	
	private String SCOPE;
	
	private Set<StudentDTO> students;
	
	
	public StudentDAO() {
		Properties properties = new Properties();
		
		try {
			properties.load(new ClassPathResource("application.properties").getInputStream());
			this.SCOPE = properties.getProperty("api.scope"); this.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Agregar estudiante ------------------------------------ //
	@Override
	public void save(StudentDTO stu) {
		boolean removed = this.delete(stu.getId());
		
		if (!removed) stu.setId((this.students.size() + 1L));
		
		students.add(stu);
		
		this.saveData();
	}
	
	// Eliminar estudiante ------------------------------------ //
	@Override
	public boolean delete(Long id) {
		boolean ret = false;
		
		try {
			StudentDTO found = this.findById(id);
			
			students.remove(found); ret = true; this.saveData();
			
		} catch (StudentNotFoundException e) {
		} return ret;
	}
	
	// Existe estudiante ------------------------------------ //
	public boolean exists(StudentDTO stu) {
		boolean ret = false;
		
		try {
			ret = this.findById(stu.getId()) != null;
		} catch (StudentNotFoundException e) {
		}
		
		return ret;
	}
	
	// Buscar un estudiante ------------------------------------ //
	@Override
	public StudentDTO findById(Long id) {
		return students.stream().filter(stu -> stu.getId().equals(id)).findFirst()
						.orElseThrow(() -> new StudentNotFoundException(id));
	}
	
	// Find All   ------------------------------------ //
	@Override
	public Set<StudentDTO> findAll() {
		Set<StudentDTO> loadedData = new HashSet<>();
		
		ObjectMapper objectMapper = new ObjectMapper(); try {
			File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
			loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
		} catch (FileNotFoundException e) {
			e.printStackTrace(); System.out.println("Failed while initializing DB, check your resources files");
		} catch (IOException e) {
			e.printStackTrace(); System.out.println("Failed while initializing DB, check your JSON formatting.");
		}
		
		return loadedData;
	}
	
	// Leer JSON   ------------------------------------ //
	private void loadData() {
		Set<StudentDTO> loadedData = new HashSet<>();
		
		ObjectMapper objectMapper = new ObjectMapper(); File file; try {
			file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
			loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
		} catch (FileNotFoundException e) {
			e.printStackTrace(); System.out.println("Failed while initializing DB, check your resources files");
		} catch (IOException e) {
			e.printStackTrace(); System.out.println("Failed while initializing DB, check your JSON formatting.");
		}
		
		this.students = loadedData;
	}
	
	// Escribir JSON   ------------------------------------ //
	private void saveData() {
		ObjectMapper objectMapper = new ObjectMapper(); try {
			File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
			objectMapper.writeValue(file, this.students);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); System.out.println("Failed while writing to DB, check your resources files");
		} catch (IOException e) {
			e.printStackTrace(); System.out.println("Failed while writing to DB, check your JSON formatting.");
		}
	}
	
	// Genero un setter para los tests
	void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}
	
}
