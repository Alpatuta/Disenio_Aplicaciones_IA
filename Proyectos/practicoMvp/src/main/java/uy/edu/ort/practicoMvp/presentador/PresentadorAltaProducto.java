package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import uy.edu.ort.practicoMvp.modelo.Producto;
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

    @PostMapping("/altaProductoVerificarNombre")
    public Commands verificarNombre(String nombre) {
        Producto p = new Producto();
        boolean cumple = false;
        if (!p.verificarNombre(nombre)) {
            return Commands.create(mostrarMensaje("Nombre del producto incorrecto" + p.toString()));
        } else if (sistemaStock.existeProducto(nombre)) {
            return Commands.create(mostrarMensaje("El producto ya existe" + p.toString()));
        } else {
            return Commands.create(mostrarMensaje("Nombre del producto válido"));
        }
    }

    private Command mostrarMensaje(String mensaje) {
        return new Command("MENSAJE", mensaje);
    }
}
