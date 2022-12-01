package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	// Atributos
	private Long id = 0L;
	private List<Localizador> localizadorList = new ArrayList<>();
	
	// Constructores
	
	public Cliente(Long id, List<Localizador> localizadorList) {
		this.id = id;
		this.localizadorList = localizadorList;
	}
	
	public Cliente() {
		this.id += 1;
	}
	
	public Cliente(long id) {}
	
	// Getters y setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Localizador> getLocalizadorList() {
		return localizadorList;
	}
	
	public void setLocalizadorList(List<Localizador> localizadorList) {
		this.localizadorList = localizadorList;
	}
	
	// Métodos
	@Override
	public String toString() {
		return "Cliente: " +
						"\n ID: " + id +
						"Localizadores: " + localizadorList;
	}
	
	public void agregarLocalizador(Localizador localizador){
		localizadorList.add(localizador);
	}
	
}
