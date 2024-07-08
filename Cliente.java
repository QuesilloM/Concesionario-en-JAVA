/**
 * Clase que representa un Cliente.
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;

    /**
     * Constructor para crear un Cliente.
     *
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param cedula Cédula del cliente.
     */
    public Cliente(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Cédula: " + cedula;
    }
}
