package repository;

import model.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository implements IRepository<Localizador> {
	
	List<Localizador> localizadorList = new ArrayList<>();
	
	
	@Override
	public Localizador agregar(Localizador localizador) {
		localizadorList.add(localizador);
		return localizador;
	}
	
	@Override
	public Localizador buscarPorId(Long id) {
		Localizador localizadorEncontrado = (Localizador) localizadorList.stream()
						.filter(localizador -> localizador.getId()==id);
		return localizadorEncontrado;
	}
	
	@Override
	public List<Localizador> buscarTodos() {
		return localizadorList;
	}
	
	@Override
	public void eliminarPorId(Long id) {
	Localizador localizadorEncontrado = buscarPorId(id);
	localizadorList.remove(localizadorEncontrado);
	}
	
	
}
