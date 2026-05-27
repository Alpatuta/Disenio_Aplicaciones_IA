package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class TipoBusqueda {

    String filtro;

    public TipoBusqueda(String filtro) {
        this.filtro = filtro;
    }

    public String getFiltro() {
        return filtro;
    }

    public abstract List<Contacto> filtrar(String filtro, List<Contacto> contactos);
}
