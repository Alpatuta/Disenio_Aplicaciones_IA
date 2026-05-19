package uy.edu.ort.agenda.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import uy.edu.ort.agenda.dominio.UsuarioAgenda;
import uy.edu.ort.agenda.dominio.UsuarioConectado;

public class UsuarioConectadoDto {
    @Getter
    private UsuarioAgenda usuario;

    @Getter
    private LocalDateTime fechaConexion;

    public UsuarioConectadoDto(UsuarioConectado usuario) {
        this.usuario = usuario.getUsuario();
        this.fechaConexion = usuario.getFechaConexion();
    }
}
