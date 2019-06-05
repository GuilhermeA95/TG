package tg.com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tg.com.br.domain.Veiculo;
import tg.com.br.repositories.VeiculoRepository;
import tg.com.br.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo buscarPorcodVeiculo(Integer codVeiculo) {
		Optional<Veiculo> obj = veiculoRepository.findById(codVeiculo);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado! código: " + codVeiculo));
	}
	
	
	public Veiculo salvar(Veiculo veiculo) {
		veiculo.setCodVeiculo(null);
		return veiculoRepository.save(veiculo);
	}
	
	public Veiculo atualizar(Veiculo veiculo) {
		return veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void deletar(Integer codVeiculo) {
		veiculoRepository.deleteById(codVeiculo);
	}
	
	public List<Veiculo> listar(){
		return veiculoRepository.findAll();
	}
	
}