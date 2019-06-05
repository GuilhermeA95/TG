package tg.com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tg.com.br.domain.Cliente;
import tg.com.br.repositories.ClienteRepository;
import tg.com.br.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorcodCliente(Integer codCliente) {
		Optional<Cliente> obj = clienteRepository.findById(codCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! código: " + codCliente));
	}
	
	public Cliente salvar(Cliente cliente) {
		cliente.setCodCliente(null);
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		return clienteRepository.saveAndFlush(cliente);
	}
	
	public void deletar(Integer codCliente) {
		clienteRepository.deleteById(codCliente);
	}
	
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
}