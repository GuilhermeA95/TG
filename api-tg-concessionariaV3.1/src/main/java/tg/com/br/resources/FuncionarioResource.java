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

import tg.com.br.domain.Funcionario;
import tg.com.br.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value = "/{codFuncionario}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer codFuncionario) {
		Funcionario funcionario = funcionarioService.buscarPorcodFuncionario(codFuncionario);
		return ResponseEntity.ok().body(funcionario);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Funcionario funcionario) {
		funcionario = funcionarioService.salvar(funcionario);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codFuncionario}")
				.buildAndExpand(funcionario.getCodFuncionario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{codFuncionario}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer codFuncionario, @RequestBody Funcionario funcionario) {
		funcionario.setCodFuncionario(codFuncionario);
		funcionario = funcionarioService.atualizar(funcionario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codFuncionario}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer funcionario){
		funcionarioService.deletar(funcionario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Funcionario> lista = funcionarioService.listar();
		return ResponseEntity.ok().body(lista);
	}

}


	
