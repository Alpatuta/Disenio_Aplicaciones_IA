package uy.edu.ort.practicoMvp.presentador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ort.practicoMvp.modelo.Fachada;
import uy.edu.ort.practicoMvp.modelo.Producto;

@RestController
public class PresentadorAltaProducto {
    private Fachada fachada = Fachada.getInstancia();

    @PostMapping("/mostrarProductosYProveedores")
    public Commands mostrarProductosYProveedores() {
        return Commands.create(mostrarProductos(), mostrarProveedores());
    }

    private Command mostrarProductos() {
        return new Command("OK_PRODUCTOS", productosComoMapas());
    }

    private Command mostrarProveedores() {
        return new Command("OK_PROVEEDORES", proveedoresComoMapas());
    }

    @PostMapping("/altaProductoVerificarNombre")
    public Commands verificarNombre(String nombre) {
        Producto p = new Producto();

        if (!p.verificarNombre(nombre)) {
            return Commands.create(mostrarMensaje("Nombre del producto incorrecto"));
        } else if (fachada.existeProducto(nombre)) {
            return Commands.create(mostrarMensaje("El producto ya existe"));
        } else {
            return Commands.create(new Command("NOMBRE_OK", null));
        }
    }

    @PostMapping("/altaProducto")
    public Commands altaProducto(String nombre, int precio, int unidades, String proveedor) {
        Producto p = new Producto();

        if (!p.verificarNombre(nombre) || precio < 0 || unidades < 0) {
            return Commands.create(mostrarMensaje("No se pudo agregar el producto"));
        }

        if (fachada.existeProducto(nombre)) {
            return Commands.create(mostrarMensaje("El producto ya existe"));
        }

        if (fachada.getProveedorPorNombre(proveedor) == null) {
            return Commands.create(mostrarMensaje("Debe seleccionar un proveedor válido"));
        }

        p = new Producto(nombre, precio, unidades, fachada.getProveedorPorNombre(proveedor));
        fachada.agregarProducto(p);
        return Commands.create(
                new Command("PRODUCTO_AGREGADO", productosComoMapas()),
                mostrarMensaje("Producto agregado correctamente: " + p.toString()));
    }

    private Command mostrarMensaje(String mensaje) {
        return new Command("MENSAJE", mensaje);
    }

    private List<Map<String, Object>> productosComoMapas() {
        List<Map<String, Object>> productos = new ArrayList<>();

        for (Producto producto : fachada.getProductos()) {
            Map<String, Object> fila = new LinkedHashMap<>();
            fila.put("nombre", producto.getNombre());
            fila.put("precio", producto.getPrecio());
            fila.put("unidades", producto.getUnidades());
            fila.put("proveedor", producto.getProveedor() != null ? producto.getProveedor().getNombre() : null);
            productos.add(fila);
        }

        return productos;
    }

    private List<Map<String, Object>> proveedoresComoMapas() {
        List<Map<String, Object>> proveedores = new ArrayList<>();

        fachada.getProveedores().forEach(proveedor -> {
            Map<String, Object> fila = new LinkedHashMap<>();
            fila.put("nombre", proveedor.getNombre());
            proveedores.add(fila);
        });

        return proveedores;
    }
}
