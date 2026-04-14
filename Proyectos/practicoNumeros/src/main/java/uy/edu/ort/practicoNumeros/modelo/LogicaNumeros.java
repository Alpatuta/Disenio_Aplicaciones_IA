package uy.edu.ort.practicoNumeros.modelo;

import java.util.Collection;

public class LogicaNumeros {

	private int cantidad;

	private Collection<Integer> numerosAgregados;

	private Collection<Integer> listaPares;

	private Collection<Integer> listaImpares;

	public int getFaltan() {
		return cantidad - numerosAgregados.size();
	}

	public boolean iniciar(int cantidad) {
		this.cantidad = cantidad;
		numerosAgregados.clear();
		listaImpares.clear();
		listaPares.clear();
		return validarCantidadAIngresar();
	}

	private boolean validarCantidadAIngresar() {
		return cantidad > 0;
	}

	public void agregar(int numero) {
		numerosAgregados.add(numero);
		if(esPar(numero)){
			listaPares.add(numero);
		}else{
			listaImpares.add(numero);
		}
	}

	private boolean esPar(int numero) {
		return numero % 2 == 0;
	}


	public Collection<Integer> getResultado() {
		Collection<Integer> r = numerosAgregados;

		if(listaImpares.size() > listaPares.size()){
			r = listaImpares;
		}else if(listaPares.size() > listaImpares.size()){
			r = listaPares;
		}
		return r;
	}

	public boolean hayResultado() {
		return cantidad != 0 && cantidad == numerosAgregados.size();
	}

}
