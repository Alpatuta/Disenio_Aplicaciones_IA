package uy.edu.ort.practicoMvp;

import uy.edu.ort.practicoMvp.modelo.Cliente;
import uy.edu.ort.practicoMvp.modelo.Factura;
import uy.edu.ort.practicoMvp.modelo.Fachada;
import uy.edu.ort.practicoMvp.modelo.Producto;
import uy.edu.ort.practicoMvp.modelo.Proveedor;

public class DatosPrueba {

    public static void cargar() {

        Fachada fachada = Fachada.getInstancia();

        Proveedor pA = new Proveedor("Proveedor A");
        Proveedor pB = new Proveedor("Proveedor B");
        Proveedor pC = new Proveedor("Proveedor C");

        fachada.agregarProveedor(pA);
        fachada.agregarProveedor(pB);
        fachada.agregarProveedor(pC);

        Producto caramelo = new Producto("Caramelo", 2, 3000, pA);
        Producto camisa = new Producto("Camisa", 1300, 1000, pB);
        Producto computadora = new Producto("Computadora", 20000, 40, pC);

        fachada.agregarProducto(caramelo);
        fachada.agregarProducto(camisa);
        fachada.agregarProducto(computadora);

        Cliente juan = new Cliente("12345678", "Juan", "juan@mail.uy");
        Cliente ana = new Cliente("13456789", "Ana", "ana@mail.uy");
        Cliente mario = new Cliente("21234567", "Mario", "mario@mail.uy");

        fachada.agregarCliente(juan);
        fachada.agregarCliente(ana);
        fachada.agregarCliente(mario);

        Factura f1 = new Factura(juan);
        f1.agregar(30, caramelo);
        f1.agregar(2, camisa);
        f1.agregar(1, computadora);

        fachada.agregarFactura(f1);

        Factura f2 = new Factura(ana);
        f2.agregar(400, caramelo);
        f2.agregar(20, camisa);
        f2.agregar(10, computadora);

        fachada.agregarFactura(f2);

        Factura f3 = new Factura(mario);

        f3.agregar(1, camisa);
        f3.agregar(1, computadora);

        fachada.agregarFactura(f3);
    }

}