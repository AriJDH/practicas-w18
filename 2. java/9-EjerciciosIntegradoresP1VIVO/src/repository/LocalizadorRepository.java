package repository;

import model.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LocalizadorRepository implements IRepository<Localizador> {
	
	List<Localizador> localizadorList = new ArrayList<>();
	
	
	@Override
	public Localizador agregar(Localizador localizador) {
		localizadorList.add(localizador);
		return localizador;
	}
	
	@Override
	public Localizador buscarPorId(Long id) {
		return localizadorList.stream()
						.filter(localizador -> Objects.equals(localizador.getId(), id)).findFirst()
						.orElseThrow(() -> new NoSuchElementException("El Id no se encuentra"));
		
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
