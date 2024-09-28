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

public class PeliculaDAO implements IPeliculaDAO {

    private IConexionBD conexionBD;

    public PeliculaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public PeliculaEntidad agregarPelicula(PeliculaEntidad pelicula) throws PersistenciaException {
       String query = "INSERT INTO Peliculas (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, poster, estaEliminada) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        // Configurar los parámetros de la película en el PreparedStatement.
        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getClasificacion());
        ps.setInt(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getGenero());
        ps.setString(5, pelicula.getPaisOrigen());
        ps.setString(6, pelicula.getSinopsis());
        ps.setString(7, pelicula.getLinkTrailer());

        // Almacenar la imagen como BLOB
        ps.setBytes(8, pelicula.getPoster()); // El octavo parámetro es la imagen en bytes

        ps.setBoolean(9, pelicula.isEstaEliminada());

        // Ejecutar la inserción
        ps.executeUpdate();

        // Obtener el ID generado automáticamente
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            pelicula.setId(generatedKeys.getInt(1));
        }

        return pelicula;

    } catch (SQLException e) {
        throw new PersistenciaException("Error al insertar la película: " + e.getMessage(), e);
    }
    }

    @Override
    public List<PeliculaEntidad> listarPeliculas() throws PersistenciaException {
        List<PeliculaEntidad> peliculas = new ArrayList<>();
    String query = "SELECT ID, Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, poster, estaEliminada FROM Peliculas";

    try (Connection conexion = conexionBD.crearConexion(); 
         Statement st = conexion.createStatement(); 
         ResultSet rs = st.executeQuery(query)) {

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
                    rs.getBoolean("estaEliminada"),
                    rs.getBytes("poster")  // Leer la imagen como un arreglo de bytes
            );
            peliculas.add(pelicula);
        }

    } catch (SQLException e) {
        throw new PersistenciaException("Error al listar las películas: " + e.getMessage(), e);
    }

    return peliculas;
    }

    @Override
    public PeliculaEntidad guardar(PeliculaEntidad peliculaEntidad) throws PersistenciaException {
         String sql = "INSERT INTO Peliculas (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, poster, estaEliminada) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        // Establecer los valores para los parámetros de la película
        ps.setString(1, peliculaEntidad.getTitulo());
        ps.setString(2, peliculaEntidad.getClasificacion());
        ps.setInt(3, peliculaEntidad.getDuracion());
        ps.setString(4, peliculaEntidad.getGenero());
        ps.setString(5, peliculaEntidad.getPaisOrigen());
        ps.setString(6, peliculaEntidad.getSinopsis());
        ps.setString(7, peliculaEntidad.getLinkTrailer());

        // Guardar la imagen como arreglo de bytes (BLOB)
        ps.setBytes(8, peliculaEntidad.getPoster()); // Aquí 'poster' es un byte[]

        ps.setBoolean(9, peliculaEntidad.isEstaEliminada());

        // Ejecutar la inserción
        int rowsAffected = ps.executeUpdate();

        // Obtener el ID generado automáticamente
        if (rowsAffected > 0) {
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
        String query = "SELECT ID, Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, poster, estaEliminada FROM Peliculas WHERE ID = ?";

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
                        rs.getBoolean("estaEliminada"),
                        rs.getBytes("poster")  // Recuperar la imagen como un arreglo de bytes
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
