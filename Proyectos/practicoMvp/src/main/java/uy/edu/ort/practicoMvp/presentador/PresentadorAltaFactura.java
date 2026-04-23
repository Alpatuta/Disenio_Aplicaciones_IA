package uy.edu.ort.practicoMvp.presentador;

import org.springframework.web.bind.annotation.PostMapping;

import uy.edu.ort.practicoMvp.modelo.Fachada;

public class PresentadorAltaFactura {
    private Fachada fachada = Fachada.getInstancia();

    @PostMapping("/mostrarTotalFacturas")
    public Commands mostrarTotalFacturas() {
        return Commands.create(new Command("TOTAL_FACTURAS", fachada.getTotalFacturas()));
    }

}
