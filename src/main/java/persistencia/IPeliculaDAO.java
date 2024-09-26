package persistencia;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface IPeliculaDAO {

    ArrayList< PeliculaDTO> leer() throws PersistenciaException;

    void guardar(PeliculaEntidad pelicula) throws PersistenciaException;

    void eliminar(int idPelicula) throws PersistenciaException;

    public List<PeliculaEntidad> buscarTitulo(String titulo, Tabla Filtro) throws PersistenciaException;

    PeliculaEntidad buscarPorId(int idPelicula) throws PersistenciaException;

    public List<PeliculaEntidad> buscarPeliculas(Tabla filtro) throws PersistenciaException;
    
    public IConexionBD getConexionBD();
}
