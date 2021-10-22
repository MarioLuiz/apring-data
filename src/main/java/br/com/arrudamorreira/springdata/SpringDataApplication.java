package br.com.arrudamorreira.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arrudamorreira.springdata.service.CrudCargoService;
import br.com.arrudamorreira.springdata.service.CrudFuncionarioService;
import br.com.arrudamorreira.springdata.service.CrudUnidadeService;
import br.com.arrudamorreira.springdata.service.RelatorioFuncionarioDinamico;
import br.com.arrudamorreira.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService crudCargoService;
	private final CrudUnidadeService crudUnidadeService;
	private final CrudFuncionarioService crudFuncionarioService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudUnidadeService crudUnidadeService, CrudFuncionarioService crudFuncionarioService, RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.crudCargoService = crudCargoService;
		this.crudUnidadeService = crudUnidadeService;
		this.crudFuncionarioService = crudFuncionarioService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
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
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorio funcionario dinamico");

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
			case 4:
				relatoriosService.inicial(scanner);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
}
