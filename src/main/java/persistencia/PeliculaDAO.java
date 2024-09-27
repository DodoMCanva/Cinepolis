package persistencia;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.NegocioException;
import utilerias.Tabla;

public class PeliculaDAO implements IPeliculaDAO {

    private IConexionBD conexionBD;

    public PeliculaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public PeliculaEntidad agregarPelicula(PeliculaEntidad pelicula) throws PersistenciaException {
        String query = "INSERT INTO Pelicula (ID, Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, estaEliminada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, pelicula.getId());
            stmt.setString(2, pelicula.getTitulo());
            stmt.setString(3, pelicula.getClasificacion());
            stmt.setInt(4, pelicula.getDuracion());
            stmt.setString(5, pelicula.getGenero());
            stmt.setString(6, pelicula.getPaisOrigen());
            stmt.setString(7, pelicula.getSinopsis());
            stmt.setString(8, pelicula.getLinkTrailer());
            stmt.setBoolean(9, pelicula.isEstaEliminada());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                return pelicula;
            } else {
                throw new PersistenciaException("No se pudo insertar la película.");
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar la película: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PeliculaEntidad> listarPeliculas() throws PersistenciaException {
        List<PeliculaEntidad> peliculas = new ArrayList<>();
        String query = "SELECT * FROM Pelicula";

        try (Connection conexion = conexionBD.crearConexion(); Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                PeliculaEntidad pelicula = new PeliculaEntidad(
                        rs.getInt("ID"),
                        rs.getString("Titulo"),
                        rs.getString("Clasificacion"),
                        rs.getInt("Duracion"),
                        rs.getString("Genero"),
                        rs.getString("PaisOrigen"),
                        rs.getString("Sinopsis"),
                        rs.getString("LinkTrailer"),
                        rs.getBoolean("estaEliminada")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al listar las películas", e);
        }

        return peliculas;
    }

    @Override
    public PeliculaEntidad guardar(PeliculaEntidad pelicula) throws PersistenciaException {
        String query = "INSERT INTO Pelicula (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, estaEliminada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        
        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getClasificacion());
        ps.setInt(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getGenero());
        ps.setString(5, pelicula.getPaisOrigen());
        ps.setString(6, pelicula.getSinopsis());
        ps.setString(7, pelicula.getLinkTrailer());
        ps.setBoolean(8, pelicula.isEstaEliminada());
        
        ps.executeUpdate();
        
        // Opcional: obtener el ID generado si necesitas
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            pelicula.setId(generatedKeys.getInt(1)); // Asignar el ID generado a la entidad
        }
        
        return pelicula;

    } catch (SQLException e) {
        throw new PersistenciaException("Error al insertar la película", e);
    }
    }

    @Override
    public PeliculaEntidad buscarPorId(int id) throws PersistenciaException {
        String query = "SELECT * FROM Pelicula WHERE ID = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PeliculaEntidad(
                            rs.getInt("ID"),
                            rs.getString("Titulo"),
                            rs.getString("Clasificacion"),
                            rs.getInt("Duracion"),
                            rs.getString("Genero"),
                            rs.getString("PaisOrigen"),
                            rs.getString("Sinopsis"),
                            rs.getString("LinkTrailer"),
                            rs.getBoolean("estaEliminada")
                    );
                } else {
                    throw new PersistenciaException("Película no encontrada");
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la película", e);
        }
    }

    @Override
    public PeliculaEntidad eliminarPelicula(int id) throws PersistenciaException {
        String query = "UPDATE Pelicula SET estaEliminada = ? WHERE ID = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query)) {

            ps.setBoolean(1, true);
            ps.setInt(2, id);

            ps.executeUpdate();
            return buscarPorId(id);

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la película", e);
        }
    }

}
