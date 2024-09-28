package negocio;

import dto.PeliculaDTO;
import java.util.List;

/**
 *
 * @author Valeria
 */
public interface IPeliculaNegocio {

    // Método para agregar una película, con posibles validaciones de negocio
    PeliculaDTO agregarPelicula(PeliculaDTO peliculaDTO) throws NegocioException;

    List<PeliculaDTO> listarPeliculas() throws NegocioException;

    PeliculaDTO guardar(PeliculaDTO peliculaDTO) throws NegocioException;

    // Método para obtener una película por su ID
    PeliculaDTO buscarPorId(int id) throws NegocioException;

    // Método para eliminar una película lógicamente
    PeliculaDTO eliminarPelicula(int id) throws NegocioException;
    
        List<PeliculaDTO> buscarPeliculasPorSucursalYCiudad(String ciudad, String sucursal) throws NegocioException;


//    // Método para restaurar una película que ha sido eliminada lógicamente
//    PeliculaDTO restaurarPelicula(int id) throws NegocioException;
}
