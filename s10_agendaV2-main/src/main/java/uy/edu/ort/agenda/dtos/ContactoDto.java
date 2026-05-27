package uy.edu.ort.agenda.dtos;

import uy.edu.ort.agenda.dominio.Contacto;

public class ContactoDto {

    private String nombre;
    private String numero;
    private String tipoContacto;

    public ContactoDto(Contacto contacto) {

        nombre = contacto.getNombre();
        numero = contacto.getTelefono().getNumero();
        tipoContacto = contacto.getTipoContacto().getDescripcion();

    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

}
