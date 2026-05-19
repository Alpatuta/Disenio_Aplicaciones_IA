package uy.edu.ort.agenda.dtos;

import java.time.format.DateTimeFormatter;

import lombok.Getter;
import uy.edu.ort.agenda.dominio.UsuarioConectado;

public class UsuarioConectadoDto {
    @Getter
    private String nombreCompleto;

    @Getter
    private String fechaIngreso;

    @Getter
    private int cantidadContactos;

    public UsuarioConectadoDto(UsuarioConectado uc) {
        this.nombreCompleto = uc.getUsuario().getNombreCompleto();
        this.cantidadContactos = uc.getUsuario().getAgenda().cantidadContactos();
        this.fechaIngreso = uc.getFechaConexion()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
