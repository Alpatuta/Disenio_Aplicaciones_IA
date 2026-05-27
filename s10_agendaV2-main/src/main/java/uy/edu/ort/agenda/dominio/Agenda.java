package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Agenda {
    private List<Contacto> contactos;

    private TipoBusqueda tipoBusqueda;

    public Agenda() {
        this.contactos = new ArrayList<>();
        this.tipoBusqueda = new TipoBusquedaCombinada();
    }

    public void setTipoBusqueda(TipoBusqueda tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public TipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
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

        if (filtro.isBlank()) {
            throw new AgendaException("Ingrese un texto de busqueda");
        }

        return tipoBusqueda.filtrar(filtro, contactos);
    }
}
