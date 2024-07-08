/**
 * Clase que representa un vehículo.
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private int puertas;
    private String combustible;
    private int airbags;
    private int asientos;

    /**
     * Constructor para crear un Vehiculo.
     *
     * @param marca Marca del vehículo.
     * @param modelo Modelo del vehículo.
     * @param año Año del vehículo.
     * @param precio Precio del vehículo.
     * @param puertas Número de puertas del vehículo.
     * @param combustible Tipo de combustible del vehículo.
     * @param airbags Número de airbags del vehículo.
     * @param asientos Número de asientos del vehículo.
     */
    public Vehiculo(String marca, String modelo, int año, double precio, int puertas, String combustible, int airbags, int asientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.puertas = puertas;
        this.combustible = combustible;
        this.airbags = airbags;
        this.asientos = asientos;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    /**
     * Devuelve una representación en cadena de los detalles del vehículo.
     *
     * @return Una cadena que contiene los detalles del vehículo.
     */
    @Override
    public String toString() {
        return String.format("Marca: %s, Modelo: %s, Año: %d, Precio: $%.2f, Puertas: %d, Combustible: %s, Airbags: %d, Asientos: %d",
                marca, modelo, año, precio, puertas, combustible, airbags, asientos);
    }
}
