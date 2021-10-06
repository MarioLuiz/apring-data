package br.com.arrudamorreira.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arrudamorreira.springdata.service.CrudCargoService;
import br.com.arrudamorreira.springdata.service.CrudFuncionarioService;
import br.com.arrudamorreira.springdata.service.CrudUnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService crudCargoService;
	private final CrudUnidadeService crudUnidadeService;
	private final CrudFuncionarioService crudFuncionarioService;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudUnidadeService crudUnidadeService, CrudFuncionarioService crudFuncionarioService) {
		this.crudCargoService = crudCargoService;
		this.crudUnidadeService = crudUnidadeService;
		this.crudFuncionarioService = crudFuncionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade");
			System.out.println("3 - Funcionario");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				crudCargoService.inicial(scanner);
				break;
			case 2:
				crudUnidadeService.inicial(scanner);
				break;
			case 3:
				crudFuncionarioService.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
}
