package com.food.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Characters;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.model.Ingrediente;

@Repository
public class RepositoryFood implements IRepositiryFood {

	private List<Ingrediente> listIngredientes = new ArrayList<>();

	@Override
	public List<Ingrediente> getIngredientes() {
		listIngredientes = loadList();

		return listIngredientes;
	}

	public List<Ingrediente> loadList() {

		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:food.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
		};
		List<Ingrediente> characters = null;
		try {
			characters = objectMapper.readValue(file, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return characters;
	}

}
