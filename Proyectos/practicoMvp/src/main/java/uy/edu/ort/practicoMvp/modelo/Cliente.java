package uy.edu.ort.practicoMvp.modelo;

public class Cliente {
    private String nombre;

    private String cedula;

    private String email;

    public Cliente(String nombre, String cedula, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validar() {
        return verificarCedula(cedula) && verificarEmail(email) && verificarNombre(nombre);
    }

    public boolean verificarCedula(String cedula) {
        // Verifco que la cedula sin guiones y puntos tenga entre 6 y 8 digiyos
        // numericos
        String cedulaSinGuionesYPuntos = cedula.replaceAll("[.-]", "");
        if (cedulaSinGuionesYPuntos.length() < 6 || cedulaSinGuionesYPuntos.length() > 8) {
            return false;
        }

        return true;
    }

    public boolean verificarEmail(String email) {
        boolean emailValido = emailValido(email);

        if (email == null || email.isEmpty() || !emailValido) {
            return false;
        }

        return true;
    }

    private boolean emailValido(String email) {
        // Verifico que el email tenga @ y .
        return email.contains("@") && email.contains(".");
    }

    public boolean verificarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return false;
        }
        return true;
    }

    public String ToString() {
        return "Cliente: " + nombre + " Email: " + email;
    }

}
