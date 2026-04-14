package uy.edu.ort.practicoNumeros.presentador;

import uy.edu.ort.practicoNumeros.modelo.LogicaNumeros;
import java.util.Collection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/numeros")
public class NumeroPresenter {

	private LogicaNumeros logicaNumeros;

	/**
	 * //Retorna modelo.getFaltan()
	 */
	public Collection<Commando> vistaConectada() {
		return null;
	}

	/**
	 * modelo.iniciar(cantidadAIngresar)
	 * 
	 *  
	 */
	public Collection<Commando> iniciar(int cantidadAIngresar) {
		return null;
	}

	/**
	 * modelo.agregar(numero);
	 * 
	 * if(modelo.hayResultado){
	 * //Mostrar proceso finalizado
	 * }else{
	 * //Mostrar cuantos faltan ingresar
	 * (modelo.faltan())
	 * }
	 * 
	 *  
	 */
	public Collection<Commando> ingresarNumero(int numero) {
		return null;
	}

}
