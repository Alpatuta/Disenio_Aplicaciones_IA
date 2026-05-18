package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ort.agenda.excepciones.AgendaException;

public class Agenda {
    private List<Contacto> contactos;

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

    public List<Contacto> buscar(String filtro){
        
        ArrayList<Contacto> resultado = new ArrayList<Contacto>();
        if(filtro.isBlank()) return resultado;
        for(Contacto c:contactos){
            if(c.getNombre().contains(filtro) || c.getTelefono().contains(filtro)){
                    resultado.add(c);
            }
        }
        return resultado;
    }
}
