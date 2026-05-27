package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public class TipoBusquedaNombre extends TipoBusqueda {

    public TipoBusquedaNombre(String filtro) {
        super(filtro);
    }

    public List<Contacto> filtrar(String filtro, List<Contacto> contactos) {
        List<Contacto> resultado = new ArrayList<>();

        for (Contacto c : contactos) {
            if (c.getNombre().contains(filtro)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}
