package tg.com.br.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tg.com.br.domain.Cliente;
import tg.com.br.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{codCliente}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorcodCliente(@PathVariable Integer codCliente) {
		Cliente cliente = clienteService.buscarPorcodCliente(codCliente);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
		cliente = clienteService.salvar(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codCliente}")
				.buildAndExpand(cliente.getCodCliente())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{codCliente}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer codCliente, @RequestBody Cliente cliente) {
		cliente.setCodCliente(codCliente);
		cliente = clienteService.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codCliente}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer cliente){
		clienteService.deletar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Cliente> lista = clienteService.listar();
		return ResponseEntity.ok().body(lista);
	}

}
