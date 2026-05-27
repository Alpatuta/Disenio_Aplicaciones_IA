package uy.edu.ort.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public class TipoBusquedaCombinada extends TipoBusqueda {

    public TipoBusquedaCombinada(String filtro) {
        super(filtro);
    }

    @Override
    public List<Contacto> filtrar(String filtro, List<Contacto> contactos) {
        List<Contacto> resultado = new ArrayList<>();

        for (Contacto c : contactos) {
            if (c.getNombre().contains(filtro) || c.getTelefono().getNumero().contains(filtro)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}
