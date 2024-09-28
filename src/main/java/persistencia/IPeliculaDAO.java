package persistencia;

import entidad.PeliculaEntidad;
import java.util.List;

public interface IPeliculaDAO {

    // Método para agregar una película
    PeliculaEntidad agregarPelicula(PeliculaEntidad peliculaEntidad) throws PersistenciaException;

    // Método para listar todas las películas
    List<PeliculaEntidad> listarPeliculas() throws PersistenciaException;

    // Método para guardar o actualizar una película (puedes decidir si lo llamas "guardar" o "modificar")
    PeliculaEntidad guardar(PeliculaEntidad pelicula) throws PersistenciaException;

    // Método para obtener una película por su ID
    PeliculaEntidad buscarPorId(int id) throws PersistenciaException;

    // Método para eliminar una película 
    PeliculaEntidad eliminarPelicula(int id) throws PersistenciaException;

}
