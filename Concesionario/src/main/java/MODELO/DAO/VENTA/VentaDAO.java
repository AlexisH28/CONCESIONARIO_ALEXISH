package MODELO.DAO.VENTA;

import MODELO.CONEXION.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    public void createVenta(Venta venta) {
        String sql = "INSERT INTO venta (vehiculo_id, cliente_id, empleado_id, fecha_venta, precio_venta, metodo_pago) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venta.getVehiculoId());
            stmt.setInt(2, venta.getClienteId());
            stmt.setInt(3, venta.getEmpleadoId());
            stmt.setDate(4, Date.valueOf(venta.getFechaVenta()));
            stmt.setDouble(5, venta.getPrecioVenta());
            stmt.setString(6, venta.getMetodoPago());
            stmt.executeUpdate();

            System.out.println("Venta registrada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venta> getAllVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM venta";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Venta venta = new Venta(
                        rs.getInt("venta_id"),
                        rs.getInt("vehiculo_id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDate("fecha_venta").toLocalDate(),
                        rs.getDouble("precio_venta"),
                        rs.getString("metodo_pago")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }

    public void updateVenta(Venta venta) {
        String sql = "UPDATE venta SET vehiculo_id = ?, cliente_id = ?, empleado_id = ?, fecha_venta = ?, precio_venta = ?, metodo_pago = ? WHERE venta_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venta.getVehiculoId());
            stmt.setInt(2, venta.getClienteId());
            stmt.setInt(3, venta.getEmpleadoId());
            stmt.setDate(4, Date.valueOf(venta.getFechaVenta()));
            stmt.setDouble(5, venta.getPrecioVenta());
            stmt.setString(6, venta.getMetodoPago());
            stmt.setInt(7, venta.getVentaId());
            stmt.executeUpdate();

            System.out.println("Venta actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVenta(int ventaId) {
        String sql = "DELETE FROM venta WHERE venta_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ventaId);
            stmt.executeUpdate();

            System.out.println("Venta eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

