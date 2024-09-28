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

    private IConexionBD conexionBD;

    public SucursalDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(SucursalEntidad sucursal) throws SQLException {

        String query = "INSERT INTO Sucursales (nombre, ciudad, estado, calle, codigoPostal, estaEliminado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = conexionBD.crearConexion()) {

            try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, sucursal.getNombre());
                pstmt.setString(2, sucursal.getCiudad());
                pstmt.setString(3, sucursal.getEstado());
                pstmt.setString(4, sucursal.getCalle());
                pstmt.setString(5, sucursal.getCodigoPostal());
                pstmt.setBoolean(6, sucursal.isEstaEliminado());

                pstmt.executeUpdate();
            }
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM Sucursales WHERE ID = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<SucursalEntidad> obtenerTodas(Tabla Filtro) throws SQLException {
        String query = "SELECT S.ID ,S.nombre,S.ciudad, DS.estado, DS.calle ,DS.CP ,S.fechaRegistro AS fechaHoraRegistro FROM Sucursales S "
                + "INNER JOIN Dir_Sucursal DS ON S.ID = DS.ID"
                + "LIMIT ? OFFSET ?";

        List<SucursalEntidad> sucursales = new ArrayList<>();

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, Filtro.getLimite());  // Límite de resultados
            ps.setInt(2, Filtro.getPagina() * Filtro.getLimite());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SucursalEntidad sucursal = new SucursalEntidad();
                    sucursal.setID(rs.getInt("sucursalID"));
                    sucursal.setNombre(rs.getString("sucursalNombre"));
                    sucursal.setCiudad(rs.getString("sucursalCiudad"));
                    sucursal.setEstado(rs.getString("direccionEstado")); // Desde Dir_Sucursal
                    sucursal.setCalle(rs.getString("direccionCalle")); // Desde Dir_Sucursal
                    sucursal.setCodigoPostal(rs.getString("direccionCP")); // Desde Dir_Sucursal
                    sucursal.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));

                    sucursales.add(sucursal);
                }
            }
            return sucursales;
        }
    }

    public SucursalDTO obtenerPorId(int id) throws SQLException {
        String query = "SELECT ID, nombre, ciudad FROM Sucursales WHERE ID = ?";
        SucursalDTO sucursal = null;

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sucursal = new SucursalDTO();
                sucursal.setIDSucursal(rs.getInt("ID"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursal.setCiudad(rs.getString("ciudad"));
            }
        }
        return sucursal;
    }

    public List<String> obtenerCiudades() throws SQLException {
        String query = "SELECT DISTINCT ciudad FROM Sucursales";
        List<String> ciudades = new ArrayList<>();

        try (Connection connection = conexionBD.crearConexion(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ciudades.add(rs.getString("ciudad"));
            }
        }
        return ciudades;
    }

    @Override
    public List<SucursalEntidad> obtenerPorCiudad(String ciudad) throws SQLException {
        String query = "SELECT * FROM Sucursales WHERE ciudad = ?";
        List<SucursalEntidad> sucursales = new ArrayList<>();

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement pstmt = connection.prepareStatement(query)) {
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
    public List<SucursalEntidad> buscarporDireccion(String dir, Tabla Filtro) throws PersistenciaException {
        String query = "SELECT S.ID, S.nombre, S.ciudad FROM Sucursales S JOIN Dir_Sucursal DS ON S.ID = DS.ID WHERE DS.calle LIKE ?";
        List<SucursalEntidad> sucursales = new ArrayList<>();
        try (Connection connection = conexionBD.crearConexion(); PreparedStatement pstmt = connection.prepareStatement(query)) {
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
        try (Connection connection = conexionBD.crearConexion(); PreparedStatement pstmt = connection.prepareStatement(query)) {
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
        try (Connection connection = conexionBD.crearConexion(); PreparedStatement pstmt = connection.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
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

    @Override
    public IConexionBD getConexionBD() {
        return conexionBD;
    }

}
