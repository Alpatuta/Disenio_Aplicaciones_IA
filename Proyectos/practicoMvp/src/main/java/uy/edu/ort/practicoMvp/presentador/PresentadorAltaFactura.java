package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uy.edu.ort.practicoMvp.modelo.Cliente;
import uy.edu.ort.practicoMvp.modelo.Fachada;
import uy.edu.ort.practicoMvp.modelo.Producto;

public class PresentadorAltaFactura {
    private Fachada fachada = Fachada.getInstancia();

    @PostMapping("/mostrarTotalFacturas")
    public Commands mostrarTotalFacturas() {
        return Commands.create(new Command("TOTAL_FACTURAS", fachada.getTotalFacturas()));
    }

    @PostMapping("/iniciarFacturaParaCliente")
    public Commands iniciarFacturaParaCliente(@RequestBody String cedula) {
        Cliente c = fachada.buscarCliente(cedula);
        if (c == null) {
            return Commands.create(mensaje("No se pudo iniciar la factura, verifique la cedula"));
        }

        // Verifico que no haya una factura en proceso para ese cliente
        if (fachada.clienteComproProducto(c, null)) {
            return Commands.create(mensaje("Debe finalizar la factura actual antes de iniciar otra"));
        }

        return Commands.create(new Command("FACTURA_INICIADA", fachada.iniciarFacturaParaCliente(cedula)));
    }

    @PostMapping("/agregarProductoAFactura")
    public Commands agregarProductoAFactura(@RequestBody int idProducto, int cantidad) {
        Producto p = fachada.buscarProducto(idProducto);

        if (p == null || cantidad <= 0 || !p.hayStock(cantidad)) {
            return Commands.create(mensaje("No se pudo agregar el producto"));
        }

        return Commands.create(new Command("PRODUCTO_AGREGADO", fachada.agregarProductoAFactura(idProducto, cantidad)));
    }

    private Command mensaje(String texto) {
        return new Command("MENSAJE", texto);
    }
}
