package uy.edu.ort.practicoNumeros.presentador;

import uy.edu.ort.practicoNumeros.modelo.LogicaNumeros;
import java.util.Collection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/numeros")
public class NumeroPresenter {

	private final LogicaNumeros modelo = new LogicaNumeros();

	/**
	 * //Retorna modelo.getFaltan()
	 */
	@GetMapping("vistaConectada")
	public Commands vistaConectada() {
		return Commands.create(crearComandoFaltan());
	}

	@PostMapping("iniciar")
	public Commands iniciar(int cantidadAIngresar) {
		if (modelo.iniciar(cantidadAIngresar)) {
			return Commands.create(crearComandoFaltan());
		} else {
			return Commands.create(mostrarMensaje("No se pudo iniciar el proceso"));
		}
	}

	private Command crearComandoFaltan() {
		return new Command("faltan", modelo.getFaltan());
	}

	@PostMapping("ingresar")
	public Commands ingresarNumero(@RequestParam int numero) {

		modelo.agregar(numero);

		if (modelo.hayResultado()) {

			return Commands.create(resultado(), mostrarMensaje("Proceso finalizado"));
		} else {
			// Mostrar cuantos faltan ingresar
			return Commands.create(crearComandoFaltan());
		}

	}

	private Command mostrarMensaje(String mensaje) {
		return new Command("mostrar mensaje", mensaje);
	}

	private Command resultado() {
		Collection<Integer> resultado = modelo.getResultado();
		return new Command("resultado", resultado);
	}

}
