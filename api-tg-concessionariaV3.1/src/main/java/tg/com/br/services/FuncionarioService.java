package tg.com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tg.com.br.domain.Funcionario;
import tg.com.br.repositories.FuncionarioRepository;
import tg.com.br.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario buscarPorcodFuncionario(Integer codFuncionario) {
		Optional<Funcionario> obj = funcionarioRepository.findById(codFuncionario);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! código: " + codFuncionario));
	}
	
	
	public Funcionario salvar(Funcionario funcionario) {
		funcionario.setCodFuncionario(null);
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario atualizar(Funcionario funcionario) {
		return funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void deletar(Integer codFuncionario) {
		funcionarioRepository.deleteById(codFuncionario);
	}
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
}