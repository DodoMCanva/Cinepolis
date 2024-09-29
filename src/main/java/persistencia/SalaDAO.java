package persistencia;

import entidad.SalaEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

/**
 *
 * @author cesar
 */
public class SalaDAO implements ISalaDAO {

    private IConexionBD conexionBD;

    public SalaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public ArrayList<SalaEntidad> leer() throws PersistenciaException {
        ArrayList<SalaEntidad> salas = new ArrayList<>();
        String consulta = "SELECT id, nombre FROM Salas";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SalaEntidad sala = new SalaEntidad();
                sala.setId(rs.getInt("id"));
                sala.setNombre(rs.getString("nombre"));
                salas.add(sala);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al leer las salas", e);
        }

        return salas;
    }

    @Override
    public void guardar(SalaEntidad sala) throws PersistenciaException {
        String consulta = "INSERT INTO Salas (nombre) VALUES (?)";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, sala.getNombre());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    sala.setId(idGenerado); // Establece el ID generado
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la sala", e);
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
        String consulta = "SELECT id, nombre FROM Salas WHERE id = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {

            ps.setInt(1, idSala);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sala = new SalaEntidad();
                    sala.setId(rs.getInt("id"));
                    sala.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la sala", e);
        }

        return sala;
    }

    @Override
    public List<SalaEntidad> buscarSalas(Tabla filtro) throws PersistenciaException {
        List<SalaEntidad> salas = new ArrayList<>();
    String consulta = "SELECT id, nombre FROM Salas LIMIT ? OFFSET ?";
    
    try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
        int limite = filtro.getLimite();
        int pagina = filtro.getPagina() * filtro.getLimite();
        
        // Depuración de parámetros
        System.out.println("Consulta SQL: " + consulta);
        System.out.println("Límite: " + limite);
        System.out.println("Página (Offset): " + pagina);

        ps.setInt(1, limite);
        ps.setInt(2, pagina);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SalaEntidad sala = new SalaEntidad();
                sala.setId(rs.getInt("id"));
                sala.setNombre(rs.getString("nombre"));
                salas.add(sala);
            }
        }

    } catch (SQLException e) {
        // Captura el error exacto
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
