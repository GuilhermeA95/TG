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

import tg.com.br.domain.Veiculo;
import tg.com.br.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(value = "/{codVeiculo}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorcodVeiculo(@PathVariable Integer codVeiculo) {
		Veiculo veiculo = veiculoService.buscarPorcodVeiculo(codVeiculo);
		return ResponseEntity.ok().body(veiculo);
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Veiculo veiculo) {
		veiculo = veiculoService.salvar(veiculo);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codVeiculo}")
				.buildAndExpand(veiculo.getCodVeiculo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{codVeiculo}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer codVeiculo, @RequestBody Veiculo veiculo) {
		veiculo.setCodVeiculo(codVeiculo);
		veiculo = veiculoService.atualizar(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codVeiculo}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer veiculo){
		veiculoService.deletar(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Veiculo> lista = veiculoService.listar();
		return ResponseEntity.ok().body(lista);
	}

}
