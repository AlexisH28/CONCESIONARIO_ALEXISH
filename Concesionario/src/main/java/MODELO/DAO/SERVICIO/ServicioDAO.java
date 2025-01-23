package MODELO.DAO.SERVICIO;

import MODELO.CONEXION.DatabaseConnection;
import MODELO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    public void createServicio(Servicio servicio) {
        String sql = "INSERT INTO servicio (vehiculo_id, cliente_id, empleado_id, fecha_servicio, tipo_servicio, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, servicio.getVehiculoId());
            stmt.setInt(2, servicio.getClienteId());
            stmt.setInt(3, servicio.getEmpleadoId());
            stmt.setDate(4, Date.valueOf(servicio.getFechaServicio()));
            stmt.setString(5, servicio.getTipoServicio());
            stmt.setDouble(6, servicio.getCosto());
            stmt.setString(7, servicio.getEstado());
            stmt.executeUpdate();

            System.out.println("Servicio registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Servicio> getAllServicios() {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Servicio servicio = new Servicio(
                        rs.getInt("servicio_id"),
                        rs.getInt("vehiculo_id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDate("fecha_servicio").toLocalDate(),
                        rs.getString("tipo_servicio"),
                        rs.getDouble("costo"),
                        rs.getString("estado")
                );
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicios;
    }

    public void updateServicio(Servicio servicio) {
        String sql = "UPDATE servicio SET vehiculo_id = ?, cliente_id = ?, empleado_id = ?, fecha_servicio = ?, tipo_servicio = ?, costo = ?, estado = ? WHERE servicio_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, servicio.getVehiculoId());
            stmt.setInt(2, servicio.getClienteId());
            stmt.setInt(3, servicio.getEmpleadoId());
            stmt.setDate(4, Date.valueOf(servicio.getFechaServicio()));
            stmt.setString(5, servicio.getTipoServicio());
            stmt.setDouble(6, servicio.getCosto());
            stmt.setString(7, servicio.getEstado());
            stmt.setInt(8, servicio.getServicioId());
            stmt.executeUpdate();

            System.out.println("Servicio actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteServicio(int servicioId) {
        String sql = "DELETE FROM servicio WHERE servicio_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, servicioId);
            stmt.executeUpdate();

            System.out.println("Servicio eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

