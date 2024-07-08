import java.util.ArrayList;

/**
 * Clase que representa un Auto.
 */
public class Auto extends Vehiculo {
    private String tipo;

    public Auto(String marca, String modelo, int año, double precio, int puertas, String combustible, int airbags, String tipo, int asientos) {
        super(marca, modelo, año, precio, puertas, combustible, airbags, asientos);
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en cadena de los detalles del auto.
     *
     * @return Una cadena que contiene los detalles del auto.
     */
    @Override     return super.toString() + ", Tipo: " + tipo;
    }
}
