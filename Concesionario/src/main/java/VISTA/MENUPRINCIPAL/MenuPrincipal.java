package VISTA.MENUPRINCIPAL;

import java.util.Scanner;
import MODELO.DAO.*;
import MODELO.*;
import java.util.List;

public class MenuPrincipal {
    private Scanner scanner;
    private ClienteDAO clienteDAO;
    private VehiculoDAO vehiculoDAO;
    private VentaDAO ventaDAO;
    private ServicioDAO servicioDAO;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
        clienteDAO = new ClienteDAO();
        vehiculoDAO = new VehiculoDAO();
        ventaDAO = new VentaDAO();
        servicioDAO = new ServicioDAO();
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n--- MENÚ DEL CONCESIONARIO ---");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Vehículos");
            System.out.println("3. Gestión de Ventas");
            System.out.println("4. Gestión de Servicios");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    gestionClientes();
                    break;
                case 2:
                    gestionVehiculos();
                    break;
                case 3:
                    gestionVentas();
                    break;
                case 4:
                    gestionServicios();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void gestionClientes() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Regresar al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void agregarCliente() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese documento de identidad: ");
        String documentoIdentidad = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(0, nombre, apellido, documentoIdentidad, telefono, email, direccion);
        clienteDAO.createCliente(cliente);
    }

    private void listarClientes() {
        List<Cliente> clientes = clienteDAO.getAllClientes();
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void actualizarCliente() {
        System.out.print("Ingrese el documento de identidad del cliente a actualizar: ");
        String documentoIdentidad = scanner.nextLine();

        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nuevo apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese nuevo teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese nuevo email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese nueva dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(0, nombre, apellido, documentoIdentidad, telefono, email, direccion);
        clienteDAO.updateCliente(cliente);
    }

    private void eliminarCliente() {
        System.out.print("Ingrese el documento de identidad del cliente a eliminar: ");
        String documentoIdentidad = scanner.nextLine();
        clienteDAO.deleteCliente(documentoIdentidad);
    }

    private void gestionVehiculos() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Actualizar Vehículo");
            System.out.println("4. Eliminar Vehículo");
            System.out.println("5. Regresar al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    actualizarVehiculo();
                    break;
                case 4:
                    eliminarVehiculo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void agregarVehiculo() {
        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese año: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese estado (nuevo/usado): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese color: ");
        String color = scanner.nextLine();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Vehiculo vehiculo = new Vehiculo(0, marca, modelo, anio, precio, estado, placa, color, disponible);
        vehiculoDAO.createVehiculo(vehiculo);
    }

    private void listarVehiculos() {
        List<Vehiculo> vehiculos = vehiculoDAO.getAllVehiculos();
        System.out.println("\n--- LISTA DE VEHÍCULOS ---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

    private void actualizarVehiculo() {
        System.out.print("Ingrese la placa del vehículo a actualizar: ");
        String placa = scanner.nextLine();

        System.out.print("Ingrese nueva marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese nuevo modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese nuevo año: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese nuevo precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese nuevo estado (nuevo/usado): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese nuevo color: ");
        String color = scanner.nextLine();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Vehiculo vehiculo = new Vehiculo(0, marca, modelo, anio, precio, estado, placa, color, disponible);
        vehiculoDAO.updateVehiculo(vehiculo);
    }

    private void eliminarVehiculo() {
        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();
        vehiculoDAO.deleteVehiculo(placa);
    }

    private void gestionVentas() {
        System.out.println("Gestión de ventas aún no implementada.");
    }

    private void gestionServicios() {
        System.out.println("Gestión de servicios aún no implementada.");
    }

    private void gestionVentas() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE VENTAS ---");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Listar Ventas");
            System.out.println("3. Actualizar Venta");
            System.out.println("4. Eliminar Venta");
            System.out.println("5. Regresar al Menú Principal");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    listarVentas();
                    break;
                case 3:
                    actualizarVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void registrarVenta() {
        System.out.print("Ingrese el ID del vehículo: ");
        int vehiculoId = scanner.nextInt();
        System.out.print("Ingrese el ID del cliente: ");
        int clienteId = scanner.nextInt();
        System.out.print("Ingrese el ID del empleado: ");
        int empleadoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la fecha de la venta (AAAA-MM-DD): ");
        LocalDate fechaVenta = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese el precio de la venta: ");
        double precioVenta = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese el método de pago: ");
        String metodoPago = scanner.nextLine();

        Venta venta = new Venta(0, vehiculoId, clienteId, empleadoId, fechaVenta, precioVenta, metodoPago);
        ventaDAO.createVenta(venta);
    }

    private void listarVentas() {
        List<Venta> ventas = ventaDAO.getAllVentas();
        System.out.println("\n--- LISTA DE VENTAS ---");
        for (Venta venta : ventas) {
            System.out.println(venta);
        }
    }

    private void actualizarVenta() {
        System.out.print("Ingrese el ID de la venta a actualizar: ");
        int ventaId = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID del vehículo: ");
        int vehiculoId = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID del cliente: ");
        int clienteId = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID del empleado: ");
        int empleadoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la nueva fecha de la venta (AAAA-MM-DD): ");
        LocalDate fechaVenta = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese el nuevo precio de la venta: ");
        double precioVenta = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo método de pago: ");
        String metodoPago = scanner.nextLine();

        Venta venta = new Venta(ventaId, vehiculoId, clienteId, empleadoId, fechaVenta, precioVenta, metodoPago);
        ventaDAO.updateVenta(venta);
    }

    private void eliminarVenta() {
        System.out.print("Ingrese el ID de la venta a eliminar: ");
        int ventaId = scanner.nextInt();
        ventaDAO.deleteVenta(ventaId);
    }

    public static void main(String[] args) {
        new MenuPrincipal().mostrarMenuPrincipal();
    }
}

