package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IRepository<Cliente>{
	
	List<Cliente> clienteList = new ArrayList<>();
	
	@Override
	public Cliente agregar(Cliente cliente) {
		 clienteList.add(cliente);
		 return cliente;
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		Cliente clienteEncontrado = (Cliente) clienteList.stream().filter(cliente -> cliente.getId()== id);
		return clienteEncontrado;
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
