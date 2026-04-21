package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import uy.edu.ort.practicoMvp.modelo.Cliente;
import uy.edu.ort.practicoMvp.modelo.SistemaClientes;

public class PresentadorAltaCliente {
    private SistemaClientes sc = SistemaClientes.getInstancia();

    @GetMapping("/mostrarClientes")
    public Commands mostrarClientes() {
        return Commands.create(new Command("OK", sc.getClientes()));
    }

    @PostMapping("/altaClienteVerificarCedula")
    public Commands verificarCedula(String cedula) {
        Cliente c = new Cliente();

        if (!c.verificarCedula(cedula)) {
            return Commands.create(mostrarMensaje("Cédula del cliente incorrecta"));
        } else if (sc.existeCliente(cedula)) {
            return Commands.create(mostrarMensaje("El cliente ya existe"));
        } else {
            c.setCedula(cedula);
            return Commands.create(mostrarMensaje("Cédula del cliente válida"));
        }
    }

    @PostMapping("/altaCliente")
    public Commands altaCliente(String nombre, String email) {
        Cliente c = new Cliente();

        if (!c.verificarNombre(nombre) || !c.verificarEmail(email)) {
            return Commands.create(mostrarMensaje("Datos del cliente incorrectos"));
        }

        c.setNombre(nombre);
        c.setEmail(email);

        if (sc.agregar(c)) {
            return Commands.create((mostrarMensaje("Cliente agregado correctamente")));
        } else {
            return Commands.create(mostrarMensaje("Error al agregar cliente"));
        }
    }

    private Command mostrarMensaje(String mensaje) {
        return new Command("MENSAJE", mensaje);
    }
}
