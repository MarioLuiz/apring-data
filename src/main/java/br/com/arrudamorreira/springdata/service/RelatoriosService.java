package br.com.arrudamorreira.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.arrudamorreira.springdata.orm.Cargo;
import br.com.arrudamorreira.springdata.orm.Funcionario;
import br.com.arrudamorreira.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario Nome");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			default:
				system = false;
				break;
			}

		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		
		System.out.println("Digite o nome do Funcionario: ");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
		
		System.out.println("- Fim -");
		System.out.println("");
		
	}
}
