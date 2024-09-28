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
        // Notar que el ID ya no se incluye en el query, ya que será generado automáticamente por la base de datos.
        String query = "INSERT INTO Peliculas (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, estaEliminada) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Configurar los parámetros de la película en el PreparedStatement.
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getClasificacion());
            ps.setInt(3, pelicula.getDuracion());
            ps.setString(4, pelicula.getGenero());
            ps.setString(5, pelicula.getPaisOrigen());
            ps.setString(6, pelicula.getSinopsis());
            ps.setString(7, pelicula.getLinkTrailer());
            ps.setBoolean(8, pelicula.isEstaEliminada());

            // Ejecutar la inserción.
            ps.executeUpdate();

            // Obtener el ID generado automáticamente por la base de datos.
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                pelicula.setId(generatedKeys.getInt(1));  // Asignar el ID generado a la entidad.
            }

            return pelicula;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar la película: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PeliculaEntidad> listarPeliculas() throws PersistenciaException {
         List<PeliculaEntidad> peliculas = new ArrayList<>();
        String query = "SELECT * FROM Peliculas";

        try (Connection conexion = conexionBD.crearConexion(); 
             Statement st = conexion.createStatement(); 
             ResultSet rs = st.executeQuery(query)) {

            // Iterar sobre los resultados del ResultSet.
            while (rs.next()) {
                PeliculaEntidad pelicula = new PeliculaEntidad(
                        rs.getInt("ID"),
                        rs.getString("titulo"),
                        rs.getString("clasificacion"),
                        rs.getInt("duracion"),
                        rs.getString("genero"),
                        rs.getString("paisOrigen"),
                        rs.getString("sinopsis"),
                        rs.getString("linkTrailer"),
                        rs.getBoolean("estaEliminada")
                );
                peliculas.add(pelicula);  // Agregar la película a la lista.
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al listar las películas: " + e.getMessage(), e);
        }

        return peliculas;
    }

    @Override
    public PeliculaEntidad guardar(PeliculaEntidad peliculaEntidad) throws PersistenciaException {
       String sql = "INSERT INTO Peliculas (titulo, clasificacion, duracion, genero, paisOrigen, sinopsis, linkTrailer, estaEliminada) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         
        ps.setString(1, peliculaEntidad.getTitulo());
        ps.setString(2, peliculaEntidad.getClasificacion());
        ps.setInt(3, peliculaEntidad.getDuracion());
        ps.setString(4, peliculaEntidad.getGenero());
        ps.setString(5, peliculaEntidad.getPaisOrigen());
        ps.setString(6, peliculaEntidad.getSinopsis());
        ps.setString(7, peliculaEntidad.getLinkTrailer());
        ps.setBoolean(8, peliculaEntidad.isEstaEliminada());
        
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            // Obtener el ID generado y asignarlo a la entidad si es necesario
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    peliculaEntidad.setId(rs.getInt(1));
                }
            }
        }
        
        return peliculaEntidad;
    } catch (SQLException e) {
        throw new PersistenciaException("Error al guardar la película", e);
    }
    }

    @Override
    public PeliculaEntidad buscarPorId(int id) throws PersistenciaException {
         String query = "SELECT * FROM Peliculas WHERE ID = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PeliculaEntidad(
                            rs.getInt("ID"),
                            rs.getString("titulo"),
                            rs.getString("clasificacion"),
                            rs.getInt("duracion"),
                            rs.getString("genero"),
                            rs.getString("paisOrigen"),
                            rs.getString("sinopsis"),
                            rs.getString("linkTrailer"),
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
 String query = "UPDATE Peliculas SET estaEliminada = ? WHERE ID = ?";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(query)) {

            ps.setBoolean(1, true);  // Cambiar el estado de eliminación a verdadero (lógica).
            ps.setInt(2, id);

            ps.executeUpdate();
            return buscarPorId(id);  // Devolver la película eliminada.

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la película", e);
        }
    }

}
