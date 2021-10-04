package br.com.arrudamorreira.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.arrudamorreira.springdata.orm.Unidade;
import br.com.arrudamorreira.springdata.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {
	
	private Boolean system = true;
	private final UnidadeRepository unidadeRepository;
	
	public CrudUnidadeService(UnidadeRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de Unidade deseja executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.print("Descricao do Unidade: ");
		String descricao = scanner.next();
		
		System.out.print("Endereco da Unidade: ");
		String endereco = scanner.next();
		
		Unidade unidade = new Unidade();
		
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o Id:");
		int id = scanner.nextInt();
		
		System.out.println("Digite a nova descricao da Unidade: ");
		String descricao = scanner.next();
		System.out.println("Digite o novo endereco da Unidade: ");
		String endereco = scanner.next();

		Unidade unidade = new Unidade();
		unidade.setId(id);
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);

		unidadeRepository.save(unidade);
		System.out.println("Alterada");
	}

	private void visualizar(Scanner scanner) {
		Iterable<Unidade> Unidades = unidadeRepository.findAll();
		Unidades.forEach(unidade -> System.out.println(unidade));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o Id:");
		int id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		
		System.out.println("Deletado");
	}

}
