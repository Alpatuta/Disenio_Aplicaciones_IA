package ort.da.primerProyecto.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ort.da.primerProyecto.model.Cliente;

@RestController
@RequestMapping("/clientes")

public class ClienteController {
    @PostMapping("/crear")
    public Cliente crearCliente() {
        Cliente nuevoCliente = new Cliente() ;
        return nuevoCliente; 
    }

    @PostMapping("/crearconnombreycedula")
    public Cliente crearClienteConNombreYCedula(@RequestParam long cedula, @RequestParam String nombre) {
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        return nuevoCliente;
    }
}
