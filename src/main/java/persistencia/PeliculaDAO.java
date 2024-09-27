package persistencia;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
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
//        String sql = "INSERT INTO Pelicula (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, estaEliminada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setString(1, pelicula.getTitulo());
//            stmt.setString(2, pelicula.getClasificacion());
//            stmt.setInt(3, pelicula.getDuracion());
//            stmt.setString(4, pelicula.getGenero());
//            stmt.setString(5, pelicula.getPaisOrigen());
//            stmt.setString(6, pelicula.getSinopsis());
//            stmt.setString(7, pelicula.getLinkTrailer());
//            stmt.setBoolean(8, false); // No está eliminada al agregar
//
//            int affectedRows = stmt.executeUpdate();
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        pelicula.setId(generatedKeys.getInt(1)); // Asigna el ID generado
//                    }
//                }
//                return pelicula;
//            } else {
//                throw new PersistenciaException("No se pudo agregar la película.");
//            }
//        } catch (SQLException e) {
//            throw new PersistenciaException("Error al agregar la película: " + e.getMessage());
//        }
        return null;
//        String sql = "INSERT INTO Pelicula (Titulo, Clasificacion, Duracion, Genero, PaisOrigen, Sinopsis, LinkTrailer, estaEliminada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setString(1, pelicula.getTitulo());
//            stmt.setString(2, pelicula.getClasificacion());
//            stmt.setInt(3, pelicula.getDuracion());
//            stmt.setString(4, pelicula.getGenero());
//            stmt.setString(5, pelicula.getPaisOrigen());
//            stmt.setString(6, pelicula.getSinopsis());
//            stmt.setString(7, pelicula.getLinkTrailer());
//            stmt.setBoolean(8, false); // No está eliminada al agregar
//
//            int affectedRows = stmt.executeUpdate();
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        pelicula.setId(generatedKeys.getInt(1)); // Asigna el ID generado
//                    }
//                }
//                return pelicula;
//            } else {
//                throw new PersistenciaException("No se pudo agregar la película.");
//            }
//        } catch (SQLException e) {
//            throw new PersistenciaException("Error al agregar la película: " + e.getMessage());
//        }
  }

    @Override
    public List<PeliculaEntidad> listarPeliculas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaEntidad guardar(PeliculaEntidad pelicula) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaEntidad buscarPorId(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaEntidad eliminarPelicula(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
