package uy.edu.ort.agenda.presentadores;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/admin/usuarios-conectados")
@Scope("session")
public class PresentadorUsuariosConectados {

    private int cantidadUsuariosConectados;

}
