package uy.edu.ort.agenda.dominio;

import java.time.LocalDateTime;

import lombok.Getter;

public class UsuarioConectado {
    public UsuarioConectado(UsuarioAgenda usuario) {
        this.usuario = usuario;
        this.fechaConexion = LocalDateTime.now();
    }

    @Getter
    private LocalDateTime fechaConexion;

    @Getter
    private UsuarioAgenda usuario;

}
