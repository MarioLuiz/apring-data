package br.com.arrudamorreira.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arrudamorreira.springdata.orm.Cargo;
import br.com.arrudamorreira.springdata.repository.CargoRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	
	private final CargoRepository cargoRepository;
	
	public SpringDataApplication(CargoRepository repository) {
		this.cargoRepository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor de Software");
		cargoRepository.save(cargo);
	}
}
