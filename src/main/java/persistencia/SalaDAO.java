package persistencia;

import entidad.SalaEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilerias.Tabla;

/**
 *
 * @author cesar
 */
public class SalaDAO implements ISalaDAO {

    private IConexionBD conexionBD = new ConexionBD();

    public SalaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public SalaDAO() {

    }

    @Override
    public ArrayList<SalaEntidad> leer() throws PersistenciaException {
        ArrayList<SalaEntidad> salas = new ArrayList<>();
        String consulta = "SELECT id, nombre, costo, capacidad FROM Salas";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SalaEntidad sala = new SalaEntidad();
                sala.setId(rs.getInt("id"));
                sala.setNombre(rs.getString("nombre"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setCosto(rs.getInt("costo"));
                salas.add(sala);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al leer las salas", e);
        }

        return salas;
    }

    public float obtenerCosto(int id) throws PersistenciaException {
        ArrayList<SalaEntidad> salas = new ArrayList<>();
        String consulta = "SELECT costo FROM Salas WHERE iD = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                return rs.getInt("costo");
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al leer las salas", e);
        }
        return 0;
    }

    @Override
    public void guardar(SalaEntidad sala, int idSucursal) throws PersistenciaException {
        String query = "INSERT INTO Salas (nombre, costo, capacidad, ID_Sucursal, estaEliminada, fechaRegistro) "
                + "VALUES (?, ?, ?, ?, false, NOW())";
        System.out.println("id:"+idSucursal);
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sala.getNombre());
            stmt.setDouble(2, sala.getCosto());
            stmt.setInt(3, sala.getCapacidad());
            stmt.setInt(4, idSucursal);
            stmt.executeUpdate(); 
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar sala: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void eliminar(int idSala) throws PersistenciaException {
        String consulta = "DELETE FROM Salas WHERE id = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {

            ps.setInt(1, idSala);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la sala", e);
        }
    }

    @Override
    public SalaEntidad buscarporNumero(int idSala) throws PersistenciaException {
        SalaEntidad sala = null;
        String consulta = "SELECT id, nombre, costo, capacidad FROM Salas WHERE id = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {

            ps.setInt(1, idSala);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sala = new SalaEntidad();
                    sala.setId(rs.getInt("id"));
                    sala.setNombre(rs.getString("nombre"));
                    sala.setCapacidad(rs.getInt("capacidad"));
                    sala.setCosto(rs.getInt("costo"));
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la sala", e);
        }

        return sala;
    }

    @Override
    public List<SalaEntidad> buscarSalas(Tabla filtro, int IDS) throws PersistenciaException {
        List<SalaEntidad> salas = new ArrayList<>();
        String consulta = "SELECT id, nombre, capacidad, costo, ID_Sucursal FROM Salas  WHERE ID_Sucursal = ?  LIMIT ? OFFSET ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            int limite = filtro.getLimite();
            int pagina = filtro.getPagina() * filtro.getLimite();
            System.out.println("Consulta SQL: " + consulta);
            System.out.println("Límite: " + limite);
            System.out.println("Página (Offset): " + pagina);

            ps.setInt(1, IDS);
            ps.setInt(2, limite);
            ps.setInt(3, pagina);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SalaEntidad sala = new SalaEntidad();
                    sala.setId(rs.getInt("id"));
                    sala.setNombre(rs.getString("nombre"));
                    sala.setCapacidad(rs.getInt("capacidad"));
                    sala.setCosto(rs.getInt("costo"));
                    salas.add(sala);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            throw new PersistenciaException("Error al buscar las salas", e);
        }

        return salas;

    }

    @Override
    public IConexionBD getConexionBD() {
        return conexionBD;
    }
}
