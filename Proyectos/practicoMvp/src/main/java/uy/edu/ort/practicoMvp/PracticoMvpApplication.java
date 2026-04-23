package uy.edu.ort.practicoMvp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticoMvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticoMvpApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			DatosPrueba.cargar();
		};
	}
}
