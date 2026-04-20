package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.PostMapping;

import uy.edu.ort.practicoMvp.modelo.Cliente;
import uy.edu.ort.practicoMvp.modelo.SistemaClientes;

public class PresentadorAltaCliente {
    private final SistemaClientes sc = new SistemaClientes();

    @PostMapping("/altaCliente")
    public Command altaCliente(String nombre, String cedula, String email) {
        Cliente cliente = new Cliente(nombre, cedula, email);

        sc.agregar(cliente);
        return new Command();
    }
}
