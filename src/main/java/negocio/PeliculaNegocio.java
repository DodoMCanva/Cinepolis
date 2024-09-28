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
import utilerias.Convertidor;
import utilerias.Tabla;

public class PeliculaNegocio implements IPeliculaNegocio {

    private final IPeliculaDAO peliculaDAO;
    private Convertidor convertir = new Convertidor();

    public PeliculaNegocio() {
        // Inicializamos ClienteDAO con una nueva instancia de ConexionBD
        IConexionBD conexionBD = new ConexionBD();
        this.peliculaDAO = new PeliculaDAO(conexionBD);
    }

    @Override
    public PeliculaDTO agregarPelicula(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            // Convertir DTO a Entidad
            PeliculaEntidad peliculaEntidad = convertir.DTOaEntidad(peliculaDTO);
            // Agregar la película a través de la capa DAO
            PeliculaEntidad entidadAgregada = peliculaDAO.agregarPelicula(peliculaEntidad);
            // Convertir Entidad a DTO y devolver el resultado
            return convertir.EntidadaDTO(entidadAgregada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la película", e);
        }
    }

    @Override
    public List<PeliculaDTO> buscarPeliculas(Tabla filtro) throws NegocioException {
        try {
            List<PeliculaEntidad> peliculasEntidad = peliculaDAO.buscarPeliculas(filtro);
            List<PeliculaDTO> peliculasDTO = new ArrayList<>();
            for (PeliculaEntidad entidad : peliculasEntidad) {
                peliculasDTO.add(convertir.EntidadaDTO(entidad));
            }
            return peliculasDTO;
        } catch (PersistenciaException e) {
            System.out.println("Negocio");
            throw new NegocioException("Error al listar las películas", e);
        }
    }

    @Override
    public PeliculaDTO guardar(PeliculaDTO peliculaDTO) throws NegocioException {
        try {
            // Convertir DTO a Entidad
            PeliculaEntidad peliculaEntidad = convertir.DTOaEntidad(peliculaDTO);

            // Guardar (actualizar o insertar) la película a través de la capa DAO
            PeliculaEntidad entidadGuardada = peliculaDAO.guardar(peliculaEntidad);

            // Convertir Entidad a DTO y devolver el resultado
            return convertir.EntidadaDTO(entidadGuardada);

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
            return convertir.EntidadaDTO(peliculaEntidad);
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
            return convertir.EntidadaDTO(peliculaEliminada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la película", e);
        }
    }

    @Override
    public List<PeliculaDTO> buscarPeliculasPorSucursalYCiudad(String ciudad, String sucursal) throws NegocioException {
        try {
            List<PeliculaEntidad> peliculasEntidades = peliculaDAO.buscarPeliculasPorSucursalYCiudad(ciudad, sucursal);
            List<PeliculaDTO> peliculasDTO = new ArrayList<>();

            // Convertir de PeliculaEntidad a PeliculaDTO
            for (PeliculaEntidad entidad : peliculasEntidades) {
                PeliculaDTO dto = new PeliculaDTO();
                dto.setId(entidad.getId());
                dto.setTitulo(entidad.getTitulo());
                dto.setPoster(entidad.getPoster()); // Copiar el poster
                peliculasDTO.add(dto);
            }

            return peliculasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener las películas", e);
        }
    }

    

    

}
