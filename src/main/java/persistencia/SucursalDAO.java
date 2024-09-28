package persistencia;

import dto.SucursalDTO;
import entidad.SucursalEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public class SucursalDAO implements ISurcursalDAO {

    private Connection connection;

    public SucursalDAO(Connection connection) {
        this.connection = connection;
    }

   public List<SucursalEntidad> obtenerTodas() throws SQLException {
    String query = "SELECT ID, nombre, ciudad, estado, calle, codigoPostal, estaEliminado, fechaHoraRegistro FROM Sucursales"; // Asegúrate de seleccionar todos los campos necesarios
    List<SucursalEntidad> sucursales = new ArrayList<>();

    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            SucursalEntidad sucursal = new SucursalEntidad(); // Cambiado a SucursalEntidad
            sucursal.setID(rs.getInt("ID"));
            sucursal.setNombre(rs.getString("nombre"));
            sucursal.setCiudad(rs.getString("ciudad"));
            sucursal.setEstado(rs.getString("estado")); // Asegúrate de que este campo exista en tu base de datos
            sucursal.setCalle(rs.getString("calle")); // Asegúrate de que este campo exista en tu base de datos
            sucursal.setCodigoPostal(rs.getString("codigoPostal")); // Asegúrate de que este campo exista en tu base de datos
            sucursal.setEstaEliminado(rs.getBoolean("estaEliminado")); // Asegúrate de que este campo exista en tu base de datos
            sucursal.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro")); // Asegúrate de que este campo exista en tu base de datos
            sucursales.add(sucursal);
        }
    }
    return sucursales; // Esto ahora devuelve List<SucursalEntidad>
}

    public SucursalDTO obtenerPorId(int id) throws SQLException {
        String query = "SELECT ID, nombre, ciudad FROM Sucursales WHERE ID = ?";
        SucursalDTO sucursal = null;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sucursal = new SucursalDTO();
                    sucursal.setIDSucursal(rs.getInt("ID"));
                    sucursal.setNombre(rs.getString("nombre"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                }
            }
        }
        return sucursal;
    }

    @Override
    public void guardar(SucursalEntidad sucursal) throws SQLException {
        String query = "INSERT INTO Sucursales (nombre, ciudad) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, sucursal.getNombre());
            pstmt.setString(2, sucursal.getCiudad());
            pstmt.executeUpdate();
        }
    }

    public List<String> obtenerCiudades() throws SQLException {
        String query = "SELECT DISTINCT ciudad FROM Sucursales";
        List<String> ciudades = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ciudades.add(rs.getString("ciudad"));
            }
        }
        return ciudades;
    }
    public List<SucursalEntidad> obtenerPorCiudad(String ciudad) throws SQLException {
    String query = "SELECT * FROM Sucursales WHERE ciudad = ?";
    List<SucursalEntidad> sucursales = new ArrayList<>();

    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, ciudad);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                SucursalEntidad sucursal = new SucursalEntidad();
                sucursal.setID(rs.getInt("ID"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursal.setCiudad(rs.getString("ciudad"));
                // Si tienes más campos en la tabla, agrégales aquí
                sucursales.add(sucursal);
            }
        }
    }
    return sucursales;
}

    @Override
    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM Sucursales WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<SucursalEntidad> buscarporDireccion(String dir, Tabla Filtro) throws PersistenciaException {
        String query = "SELECT sucursal.ID, sucursal.nombre,sucursal.ciudad FROM Sucursales s JOIN Dir_Sucursal ds ON s.ID = ds.ID WHERE ds.calle LIKE ?";
        List<SucursalEntidad> sucursales = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + dir + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SucursalEntidad sucursal = new SucursalEntidad();
                    sucursal.setID(rs.getInt("ID"));
                    sucursal.setNombre(rs.getString("nombre"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                    sucursales.add(sucursal);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar sucursales por dirección", e);
        }
        return sucursales;
    }

    @Override
    public SucursalEntidad buscarporNombre(String nombre) throws PersistenciaException {
        String query = "SELECT ID, nombre, ciudad FROM Sucursales WHERE nombre = ?";
        SucursalEntidad sucursal = null;
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sucursal = new SucursalEntidad();
                    sucursal.setID(rs.getInt("ID"));
                    sucursal.setNombre(rs.getString("nombre"));
                    sucursal.setCiudad(rs.getString("ciudad"));
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar sucursal por nombre", e);
        }
        return sucursal;
    }

    @Override
    public List<SucursalEntidad> buscarSucursal(Tabla filtro) throws PersistenciaException {
        String query = "SELECT ID, nombre, ciudad FROM Sucursales WHERE 1=1";
        List<SucursalEntidad> sucursales = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                SucursalEntidad sucursal = new SucursalEntidad();
                sucursal.setID(rs.getInt("ID"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursal.setCiudad(rs.getString("ciudad"));
                sucursales.add(sucursal);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar sucursales", e);
        }
        return sucursales;
    }

}
