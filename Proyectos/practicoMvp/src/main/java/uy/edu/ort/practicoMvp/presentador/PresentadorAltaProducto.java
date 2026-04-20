package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.GetMapping;

import uy.edu.ort.practicoMvp.modelo.SistemaStock;

public class PresentadorAltaProducto {
    private SistemaStock sistemaStock = SistemaStock.getInstancia();

    @GetMapping("/mostrarProductosYProveedores")
    public Commands mostrarProductosYProveedores() {
        return Commands.create(mostrarProductos(), mostrarProveedores());
    }

    private Command mostrarProductos() {
        return new Command("OK", sistemaStock.getProductos().toString());
    }

    private Command mostrarProveedores() {
        return new Command("OK", sistemaStock.getProveedores().toString());
    }
}
