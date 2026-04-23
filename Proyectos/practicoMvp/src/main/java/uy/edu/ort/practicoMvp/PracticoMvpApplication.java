package uy.edu.ort.practicoMvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticoMvpApplication {

	public static void main(String[] args) {
		DatosPrueba.cargar();
		SpringApplication.run(PracticoMvpApplication.class, args);
	}

}
