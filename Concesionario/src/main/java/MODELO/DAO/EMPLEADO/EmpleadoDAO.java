package MODELO.DAO.EMPLEADO;

import MODELO.CONEXION.DatabaseConnection;
import MODELO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    public void createEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleado (nombre, apellido, documento_identidad, fecha_contratacion, departamento_id, salario_base, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getDocumentoIdentidad());
            stmt.setDate(4, Date.valueOf(empleado.getFechaContratacion()));
            stmt.setInt(5, empleado.getDepartamentoId());
            stmt.setDouble(6, empleado.getSalarioBase());
            stmt.setString(7, empleado.getCargo());
            stmt.executeUpdate();

            System.out.println("Empleado registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> getAllEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("empleado_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("documento_identidad"),
                        rs.getDate("fecha_contratacion").toLocalDate(),
                        rs.getInt("departamento_id"),
                        rs.getDouble("salario_base"),
                        rs.getString("cargo")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    public void updateEmpleado(Empleado empleado) {
        String sql = "UPDATE empleado SET nombre = ?, apellido = ?, documento_identidad = ?, fecha_contratacion = ?, departamento_id = ?, salario_base = ?, cargo = ? WHERE empleado_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getDocumentoIdentidad());
            stmt.setDate(4, Date.valueOf(empleado.getFechaContratacion()));
            stmt.setInt(5, empleado.getDepartamentoId());
            stmt.setDouble(6, empleado.getSalarioBase());
            stmt.setString(7, empleado.getCargo());
            stmt.setInt(8, empleado.getEmpleadoId());
            stmt.executeUpdate();

            System.out.println("Empleado actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpleado(int empleadoId) {
        String sql = "DELETE FROM empleado WHERE empleado_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empleadoId);
            stmt.executeUpdate();

            System.out.println("Empleado eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
