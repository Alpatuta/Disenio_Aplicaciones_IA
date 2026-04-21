package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.*;

import uy.edu.ort.practicoMvp.modelo.Cliente;
import uy.edu.ort.practicoMvp.modelo.SistemaClientes;

@RestController
public class PresentadorAltaCliente {

    private SistemaClientes sc = SistemaClientes.getInstancia();

    /**
     * CU paso 1 – la vista se carga y pide la lista de clientes.
     * Comando de respuesta: OK → lista de clientes (para la tabla)
     */
    @GetMapping("/mostrarClientes")
    public Commands mostrarClientes() {
        return Commands.create(new Command("OK", sc.getClientes()));
    }

    /**
     * CU paso 2 – el usuario ingresa una cédula y pide validarla.
     *
     * Comandos de respuesta:
     * MENSAJE → texto de error (cédula inválida)
     * CEDULA_EXISTE → objeto Cliente (ya existe; mostrar nombre/email)
     * CEDULA_OK → null (habilitar nombre, email y guardar)
     */
    @PostMapping("/altaClienteVerificarCedula")
    public Commands verificarCedula(String cedula) {
        Cliente temp = new Cliente();

        if (!temp.verificarCedula(cedula)) {
            return Commands.create(mensaje("Cédula incorrecta"));
        }

        Cliente existente = sc.buscarCliente(cedula);
        if (existente != null) {
            // Devolvemos MENSAJE + CEDULA_EXISTE para mostrar datos del cliente
            return Commands.create(
                    mensaje("Ya existe el cliente"),
                    new Command("CEDULA_EXISTE", existente));
        }

        // Cédula válida y libre → habilitar el resto del formulario
        return Commands.create(new Command("CEDULA_OK", null));
    }

    /**
     * CU paso 4 – el usuario completa nombre y email y quiere guardar.
     *
     * Comandos de respuesta:
     * MENSAJE → texto de error (datos incorrectos)
     * CLIENTE_AGREGADO → lista actualizada de clientes (refresca tabla y limpia
     * form)
     */
    @PostMapping("/altaCliente")
    public Commands altaCliente(String cedula, String nombre, String email) {
        Cliente c = new Cliente();

        if (!c.verificarNombre(nombre) || !c.verificarEmail(email)) {
            return Commands.create(mensaje("No se pudo agregar el cliente"));
        }

        c.setCedula(cedula);
        c.setNombre(nombre);
        c.setEmail(email);

        if (sc.agregar(c)) {
            return Commands.create(new Command("CLIENTE_AGREGADO", sc.getClientes()));
        } else {
            return Commands.create(mensaje("No se pudo agregar el cliente"));
        }
    }

    // ── Helpers ─────────────────────────────────────────────────────────────────

    private Command mensaje(String texto) {
        return new Command("MENSAJE", texto);
    }
}