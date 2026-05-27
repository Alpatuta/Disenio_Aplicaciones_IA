package uy.edu.ort.agenda.dominio;

import java.util.List;

public abstract class TipoBusqueda {

    String nombre;

    public TipoBusqueda(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract List<Contacto> filtrar(String filtro, List<Contacto> contactos);
}
