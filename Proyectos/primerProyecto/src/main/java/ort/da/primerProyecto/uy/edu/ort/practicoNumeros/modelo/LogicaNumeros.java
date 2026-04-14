package uy.edu.ort.practicoNumeros.modelo;

import java.util.Collection;

public class LogicaNumeros {

	private int cantidad;

	private Collection<Integer> numerosAgregados;

	private Collection<Integer> listaPares;

	private Collection<Integer> listaImpares;

	/**
	 * return cantidadAIngresar - numeros.size() 
	 */
	public int getFaltan() {
		return 0;
	}

	/**
	 * //Limpiar array de numeros
	 */
	public boolean iniciar(int cantidad) {
		return false;
	}

	private boolean validarCantidadAIngresar() {
		return false;
	}

	/**
	 * numerosAgregados.add(numero);
	 * // Luego pregunto si el numero es par o impar y los agrego o a listaPares o listaImpares 
	 */
	public void agregar(int numero) {

	}

	private boolean esPar(int numero) {
		return false;
	}

	/**
	 * Collection<Numero> r = numeros;
	 * if(listaImpares.size() > listaPares.size()){
	 *    r = listaImpares;
	 * }else if(listaPares.size() > listaImpares.size()){
	 *   r = listaPares;
	 * }
	 * 
	 * return r;
	 */
	public Collection<Integer> getResultado() {
		return null;
	}

	/**
	 * return cantidadAIngresar != 0 &&
	 * cantidadAIngresar == numeros.size()
	 */
	public boolean hayResultado() {
		return false;
	}

}
