package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Agenda {
    private List<Contacto> contactos;

    private TipoBusqueda tipoBusqueda;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregar(Contacto contacto) throws AgendaException {
        contacto.validar();
        contactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public int cantidadContactos() {
        return contactos.size();
    }

    public List<Contacto> buscar(String filtro) throws AgendaException {

        List<Contacto> resultado = new ArrayList<>();

        if (filtro.isBlank()) {
            throw new AgendaException("Ingrese un texto de busqueda");
        }

        if ("Numero".equals(filtro)) {
            tipoBusqueda = new TipoBusquedaNumero(filtro);

            resultado = tipoBusqueda.filtrar(filtro, contactos);
        } else if ("Nombre".equals(filtro)) {
            tipoBusqueda = new TipoBusquedaNombre(filtro);

            resultado = tipoBusqueda.filtrar(filtro, contactos);
        } else {
            tipoBusqueda = new TipoBusquedaCombinada(filtro);

            resultado = tipoBusqueda.filtrar(filtro, contactos);
        }

        return resultado;
    }
}
