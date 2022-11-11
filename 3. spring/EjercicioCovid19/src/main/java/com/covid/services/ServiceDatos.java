package com.covid.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.covid.DTO.PersonaConSintomaDTO;
import com.covid.DTO.SintomaDTO;
import com.covid.repositorio.RepoDatos;

@Service
public class ServiceDatos {

	@Autowired
	private RepoDatos datos;

	public List<SintomaDTO> getSintoma() {

		return datos.getSintomas().stream().map(s -> new SintomaDTO(s.getNombre(), s.getNivel_de_gravedad()))
				.collect(Collectors.toList());

	}

	public SintomaDTO getSintomaByName(String name) {

		return datos.getSintomas().stream().filter(s -> s.getNombre().equals(name)).findFirst()
				.map(s -> new SintomaDTO(s.getNombre(), s.getNivel_de_gravedad()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No se encontro sintoma con nombre " + name));

	}
	
	public List<PersonaConSintomaDTO> getPersonasDeRiesgo(){
		return datos.getPersonas().stream()
				.filter(p-> p.getEdad() > 60 && p.getSintomas() != null)
				.map(p -> new PersonaConSintomaDTO(p.getNombre(), p.getApellidol(),
						p.getSintomas().get(0).getNombre(), 0))
				.collect(Collectors.toList());
	}

}
