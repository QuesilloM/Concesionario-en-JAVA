import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que gestiona los vehículos, clientes y ventas en la concesionaria.
 */
public class Concesionaria {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venta> ventas;

    public Concesionaria() {
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        ventas = new ArrayList<>();
        inicializarVehiculos();
    }

    /**
     * Inicializa el inventario de vehículos con datos predefinidos.
     */
    private void inicializarVehiculos() {
        for (int i = 0; i < 5; i++) {
            vehiculos.add(new Auto("CóndorAndino", "Cupra Cóndor Sportstourer", 2024, 50000, 3, "Gasolina", 4, "Familiar", 8));
            vehiculos.add(new Auto("CóndorAndino", "AndesLS", 2024, 45000, 4, "Gasolina", 4, "Suburban", 5));
        }
    }

    /**
     * Muestra el menú principal y maneja las opciones seleccionadas por el usuario.
     */
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Mostrar tipos de autos disponibles");
            System.out.println("2. Registrar un cliente");
            System.out.println("3. Realizar una venta");
            System.out.println("4. Mostrar clientes");
            System.out.println("5. Mostrar ventas realizadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarTiposDeAutos();
                        break;
                    case 2:
                        registrarCliente();
                        break;
                    case 3:
                        realizarVenta();
                        break;
                    case 4:
                        mostrarClientes();
                        break;
                    case 5:
                        mostrarVentas();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Clear the invalid input
                opcion = 0; // Reset opcion to continue the loop
            }
        } while (opcion != 6);
    }

    /**
     * Muestra los tipos de autos disponibles en el inventario.
     */
    private void mostrarTiposDeAutos() {
        System.out.println("Marca de autos disponibles: CóndorAndino");
        int familiaresDisponibles = 0;
        int suburbanDisponibles = 0;
        Auto ejemploFamiliar = null;
        Auto ejemploSuburban = null;

        for (Vehiculo vehiculo : vehiculos) {
            if (((Auto) vehiculo).toString().contains("Familiar")) {
                familiaresDisponibles++;
                if (ejemploFamiliar == null) {
                    ejemploFamiliar = (Auto) vehiculo;
                }
            } else if (((Auto) vehiculo).toString().contains("Suburban")) {
                suburbanDisponibles++;
                if (ejemploSuburban == null) {
                    ejemploSuburban = (Auto) vehiculo;
                }
            }
        }

        System.out.println("Cantidad de autos familiares disponibles: " + familiaresDisponibles);
        if (ejemploFamiliar != null) {
            System.out.println("Ejemplo de auto familiar: " + ejemploFamiliar);
        }

        System.out.println("Cantidad de autos suburban disponibles: " + suburbanDisponibles);
        if (ejemploSuburban != null) {
            System.out.println("Ejemplo de auto suburban: " + ejemploSuburban);
        }
    }

    /**
     * Registra un nuevo cliente en el sistema.
     */
    private void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar un nuevo cliente:");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        if (apellido.isEmpty()) {
            System.out.println("El apellido no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine();
        if (cedula.isEmpty()) {
            System.out.println("La cédula no puede estar vacía.");
            return;
        }

        Cliente nuevoCliente = new Cliente(nombre, apellido, cedula);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    /**
     * Realiza una venta de un vehículo a un cliente.
     */
    private void realizarVenta() {
        Scanner scanner = new Scanner(System.in);
        if (clientes.isEmpty()) {
            System.out.println(" No hay clientes registrados.");
            return;
        }


        System.out.println("Clientes potenciales:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }

        System.out.print("Seleccione el # cliente que va a realizar la compra: ");
        int seleccionCliente;
        try {
            seleccionCliente = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // Clear the invalid input
            return;
        }
        scanner.nextLine(); // consume newline

        if (seleccionCliente < 1 || seleccionCliente > clientes.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Cliente cliente = clientes.get(seleccionCliente - 1);

        System.out.println("Seleccione el tipo de auto:");
        System.out.println("1. Familiar");
        System.out.println("2. Suburban");
        int tipoSeleccion;
        try {
            tipoSeleccion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // Clear the invalid input
            return;
        }
        scanner.nextLine(); // consume newline

        String tipoAuto = (tipoSeleccion == 1) ? "Familiar" : "Suburban";
        ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            if (((Auto) vehiculo).toString().contains(tipoAuto)) {
                vehiculosDisponibles.add(vehiculo);
            }
        }

        System.out.println("Seleccione el vehículo a vender:");
        for (int i = 0; i < vehiculosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculosDisponibles.get(i));
        }

        int seleccionVehiculo;
        try {
            seleccionVehiculo = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // Clear the invalid input
            return;
        }
        scanner.nextLine(); // consume newline

        if (seleccionVehiculo < 1 || seleccionVehiculo > vehiculosDisponibles.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Vehiculo vehiculoAVender = vehiculosDisponibles.get(seleccionVehiculo - 1);

        System.out.print("¿Desea el auto con 4 airbags (base) o 6 airbags (+20% costo)? (4/6): ");
        int seleccionAirbags;
        try {
            seleccionAirbags = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // Clear the invalid input
            return;
        }
        scanner.nextLine(); // consume newline

        double precioBase = vehiculoAVender.getPrecio();
        if (seleccionAirbags == 6) {
            precioBase *= 1.2;
        }

        System.out.print("¿Desea seguro para el vehículo por parte de la concesionaria? (Costo: 1800$) (S/N): ");
        String seguro = scanner.nextLine().toUpperCase();

        double costoSeguro = seguro.equals("S") ? 1800 : 0;

        double totalAdicionales = 200 + 20 + 5 + 30 + 50 + 30 + costoSeguro;
        double costoTotal = precioBase + totalAdicionales;
        double iva = costoTotal * 0.12; // Añadiendo el IVA
        costoTotal += iva;

        System.out.print("¿Desea hacer el pago al contado o a plazos? (C/P): ");
        String tipoPago = scanner.nextLine().toUpperCase();

        double costoFinal = costoTotal;
        String detallesPago = String.format("Tarifa Base: $200.00, Contribución ANT: $20.00, Tasa de Seguridad Vial: $5.00, Registro inicial: $30.00, Emisión de Placa: $50.00, SOAT: $30.00, Seguro: $%.2f, Precio Vehículo: $%.2f, IVA: $%.2f", costoSeguro, precioBase, iva);

        if (tipoPago.equals("P")) {
            System.out.print("¿En cuántos meses desea pagar? (12 a 72 meses): ");
            int meses;
            try {
                meses = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Clear the invalid input
                return;
            }
            scanner.nextLine(); // consume newline

            if (meses < 12 || meses > 72) {
                System.out.println("Selección no válida.");
                return;
            }

            double interes = 0.05;
            double costoTotalConInteres = costoTotal * Math.pow((1 + interes), (meses / 12.0));
            double pagoMensual = costoTotalConInteres / meses;
            costoFinal = costoTotalConInteres;
            detallesPago += String.format(", Interés: 5%%, Meses: %d, Pago Mensual: $%.2f", meses, pagoMensual);
            System.out.println(String.format("El costo total con interés es: $%.2f", costoTotalConInteres));
            System.out.println(String.format("El pago mensual es: $%.2f", pagoMensual));
            System.out.println(String.format("El pago total al finalizar el plazo es: $%.2f", costoTotalConInteres));
        } else {
            System.out.println(String.format("El costo total al contado es: $%.2f", costoTotal));
        }

        System.out.print("¿Desea proceder con la compra? (S/N): ");
        String procederCompra = scanner.nextLine().toUpperCase();

        if (procederCompra.equals("S")) {
            ventas.add(new Venta(cliente, vehiculoAVender, costoFinal, detallesPago));
            vehiculos.remove(vehiculoAVender);
            System.out.println("¡Gracias por el pago, la CONCESIONARIA agradece su elección!");
        } else {
            System.out.println("La compra ha sido cancelada.");
        }
    }

    /**
     * Muestra los clientes registrados en el sistema.
     */
    private void mostrarClientes() {
        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Muestra las ventas realizadas y la cantidad de autos disponibles.
     */
    private void mostrarVentas() {
        System.out.println("Ventas realizadas:");
        for (Venta venta : ventas) {
            System.out.println(venta);
        }

        int familiaresDisponibles = 0;
        int suburbanDisponibles = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (((Auto) vehiculo).toString().contains("Familiar")) {
                familiaresDisponibles++;
            } else if (((Auto) vehiculo).toString().contains("Suburban")) {
                suburbanDisponibles++;
            }
        }

        System.out.println("Cantidad de autos familiares disponibles: " + familiaresDisponibles);
        System.out.println("Cantidad de autos suburban disponibles: " + suburbanDisponibles);
    }

    public static void main(String[] args) {
        Concesionaria concesionaria = new Concesionaria();
        concesionaria.mostrarMenu();
    }
}
