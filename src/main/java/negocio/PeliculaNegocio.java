package negocio;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import java.util.ArrayList;
import java.util.List;
import persistencia.ConexionBD;
import persistencia.IConexionBD;
import persistencia.IPeliculaDAO;
import persistencia.PeliculaDAO;
import persistencia.PersistenciaException;
import utilerias.Tabla;

public class PeliculaNegocio implements IPeliculaNegocio {

    private final IPeliculaDAO peliculaDAO;

    public PeliculaNegocio() {
        // Inicializamos ClienteDAO con una nueva instancia de ConexionBD
        IConexionBD conexionBD = new ConexionBD();
        this.peliculaDAO = new PeliculaDAO(conexionBD);
    }

    @Override
    public PeliculaDTO agregarPelicula(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            // Convertir DTO a Entidad
            PeliculaEntidad peliculaEntidad = convertirDTOaEntidad(peliculaDTO);
            // Agregar la película a través de la capa DAO
            PeliculaEntidad entidadAgregada = peliculaDAO.agregarPelicula(peliculaEntidad);
            // Convertir Entidad a DTO y devolver el resultado
            return convertirEntidadADTO(entidadAgregada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la película", e);
        }
    }

    @Override
    public List<PeliculaDTO> buscarPeliculas(Tabla filtro) throws NegocioException {
        try {
            List<PeliculaEntidad> peliculasEntidad = peliculaDAO.listarPeliculas();
            List<PeliculaDTO> peliculasDTO = new ArrayList<>();
            // Convertir cada PeliculaEntidad a PeliculaDTO
            for (PeliculaEntidad entidad : peliculasEntidad) {
                peliculasDTO.add(convertirEntidadADTO(entidad));
            }
            return peliculasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al listar las películas", e);
        }
    }

    @Override
    public PeliculaDTO guardar(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            // Convertir DTO a Entidad
            PeliculaEntidad peliculaEntidad = convertirDTOaEntidad(peliculaDTO);

            // Guardar (actualizar o insertar) la película a través de la capa DAO
            PeliculaEntidad entidadGuardada = peliculaDAO.guardar(peliculaEntidad);

            // Convertir Entidad a DTO y devolver el resultado
            return convertirEntidadADTO(entidadGuardada);

        } catch (PersistenciaException e) {
            // Mostrar la excepción completa
            e.printStackTrace();
            throw new NegocioException("Error al guardar la película: " + e.getMessage(), e);
        }
    }

    @Override
    public PeliculaDTO buscarPorId(int id) throws NegocioException {
        try {
            PeliculaEntidad peliculaEntidad = peliculaDAO.buscarPorId(id);
            // Convertir Entidad a DTO
            return convertirEntidadADTO(peliculaEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la película por ID", e);
        }
    }

    @Override
    public PeliculaDTO eliminarPelicula(int id) throws NegocioException {
        try {
            // Eliminar lógicamente la película
            PeliculaEntidad peliculaEliminada = peliculaDAO.eliminarPelicula(id);
            // Convertir la Entidad eliminada a DTO
            return convertirEntidadADTO(peliculaEliminada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la película", e);
        }
    }

    private PeliculaDTO convertirEntidadADTO(PeliculaEntidad entidad) {
        return new PeliculaDTO(
                entidad.getId(),
                entidad.getTitulo(),
                entidad.getClasificacion(),
                entidad.getDuracion(),
                entidad.getGenero(),
                entidad.getPaisOrigen(),
                entidad.getSinopsis(),
                entidad.getLinkTrailer(),
                entidad.isEstaEliminada(),
                entidad.getPoster()
        );
    }

    private PeliculaEntidad convertirDTOaEntidad(PeliculaDTO dto) {
        return new PeliculaEntidad(
                dto.getId(),
                dto.getTitulo(),
                dto.getClasificacion(),
                dto.getDuracion(),
                dto.getGenero(),
                dto.getPaisOrigen(),
                dto.getSinopsis(),
                dto.getLinkTrailer(),
                dto.isEstaEliminada(),
                dto.getPoster()
        );
    }
}
