package tg.com.br;


import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tg.com.br.domain.Cliente;
import tg.com.br.domain.Funcionario;
import tg.com.br.domain.Veiculo;

import tg.com.br.repositories.ClienteRepository;
import tg.com.br.repositories.FuncionarioRepository;
import tg.com.br.repositories.VeiculoRepository;


@SpringBootApplication
public class ApiTgConcessionariaApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRep;
	
	@Autowired
	private FuncionarioRepository funcionarioRep;
	
	@Autowired
	private VeiculoRepository veiculoRep;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiTgConcessionariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		

		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Terry Johny");
		funcionario.setCpf("033-806-93-79");
		funcionario.setEndereco("Surubim, Rua Vicente 59");
		funcionario.setSalario((double) 899.90);
	
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Lelis Taylor");
		funcionario2.setCpf("313-202-22-15");
		funcionario2.setEndereco("Surubim, Rua Jonas 69");
		funcionario2.setSalario((double) 999.90);
	
		
		Cliente cliente = new Cliente();
		cliente.setNome("José Francisco");
		cliente.setCpf("044-407-23-09");
		cliente.setEndereco("Caruaru, Rua Silva 29");
		cliente.setDataCadastro(new Date());
		//cliente.setFuncionario(funcionario);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Maria Almeida");
		cliente2.setCpf("052-107-22-01");
		cliente2.setEndereco("Caruaru, Rua Amaro 19");
		cliente2.setDataCadastro(new Date());
		//cliente2.setFuncionario(funcionario2);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Jonas Pedro");
		cliente3.setCpf("012-307-11-01");
		cliente3.setEndereco("Caruaru, Rua Lila 49");
		cliente3.setDataCadastro(new Date());
		
		clienteRep.saveAll(Arrays.asList(cliente, cliente2, cliente3));
	
		
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Punto");
		veiculo.setAno(2008);
		veiculo.setValor((double) 21899.90);
		veiculo.setCliente(cliente);
		//veiculo.getClientes().add(cliente3);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setMarca("Ford");
		veiculo2.setModelo("Ka");
		veiculo2.setAno(2010);
		veiculo2.setValor((double) 11799.90);	
		veiculo2.setCliente(cliente2);
		
		Veiculo veiculo3 = new Veiculo();
		veiculo3.setMarca("Ferrari");
		veiculo3.setModelo("Enzo");
		veiculo3.setAno(2012);
		veiculo3.setValor((double) 134999.90);
		veiculo3.setCliente(cliente2);
		

		veiculoRep.save(veiculo);
		veiculoRep.save(veiculo2);
		veiculoRep.save(veiculo3);
		
		
		funcionario.getVeiculos().add(veiculo);
		funcionario2.getVeiculos().add(veiculo2);
		funcionario.getVeiculos().add(veiculo3);
			
		
		funcionarioRep.save(funcionario);
		funcionarioRep.save(funcionario2);

		
		// veiculoRep.saveAll(Arrays.asList(veiculo, veiculo2, veiculo3));
		
		// funcionarioRep.saveAll(Arrays.asList(funcionario, funcionario2));
	
		
	
	}

}
	
