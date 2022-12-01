package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ClienteRepository implements IRepository<Cliente>{
	
	List<Cliente> clienteList = new ArrayList<>();
	
	@Override
	public Cliente agregar(Cliente cliente) {
		 clienteList.add(cliente);
		 return cliente;
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		return clienteList.stream().filter(cliente -> Objects.equals(cliente.getId(),
		                                                             id)).findFirst().orElseThrow(()-> new NoSuchElementException("El Id no se encuentra"));
	}
	
	@Override
	public List<Cliente> buscarTodos() {
		return clienteList;
	}
	
	@Override
	public void eliminarPorId(Long id) {
		Cliente clienteEncontrado = buscarPorId(id);
		clienteList.remove(clienteEncontrado);
	}
}
