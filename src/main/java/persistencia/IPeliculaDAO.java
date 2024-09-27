package persistencia;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import java.util.ArrayList;
import java.util.List;
import negocio.NegocioException;
import utilerias.Tabla;

public interface IPeliculaDAO {

    // Método para agregar una película
    PeliculaEntidad agregarPelicula(PeliculaEntidad pelicula) throws PersistenciaException;

    // Método para listar todas las películas
    List<PeliculaEntidad> listarPeliculas() throws PersistenciaException;

    // Método para guardar o actualizar una película (puedes decidir si lo llamas "guardar" o "modificar")
    PeliculaEntidad guardar(PeliculaEntidad pelicula) throws PersistenciaException;

    // Método para obtener una película por su ID
    PeliculaEntidad buscarPorId(int id) throws PersistenciaException;

    // Método para eliminar una película lógicamente
    PeliculaEntidad eliminarPelicula(int id) throws PersistenciaException;

//    // Método para restaurar una película que ha sido eliminada lógicamente
//    PeliculaEntidad restaurarPelicula(int id) throws NegocioException;
}
