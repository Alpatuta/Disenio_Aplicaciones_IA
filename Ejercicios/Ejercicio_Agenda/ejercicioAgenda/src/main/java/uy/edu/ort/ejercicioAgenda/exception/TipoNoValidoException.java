package uy.edu.ort.ejercicioAgenda.exception;

public class TipoNoValidoException extends Exception {
    public TipoNoValidoException() {
        super("El tipo de contacto no es válido.");
    }

    public TipoNoValidoException(String mensaje) {
        super(mensaje);
    }

}
