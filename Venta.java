public class Venta {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costoFinal;
    private String detallesVenta;

    public Venta(Cliente cliente, Vehiculo vehiculo, double costoFinal, String detallesVenta) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.costoFinal = costoFinal;
        this.detallesVenta = detallesVenta;
    }

    @Override
    public String toString() {
        return "Venta realizada a: " + cliente + ", VehÃ­culo: " + vehiculo + ", Costo Final: $" + String.format("%.2f", costoFinal) + "\nDetalles: " + detallesVenta;
    }
}


