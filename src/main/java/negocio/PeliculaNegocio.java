package negocio;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ConexionBD;
import persistencia.IConexionBD;
import persistencia.IPeliculaDAO;
import persistencia.PeliculaDAO;
import persistencia.PersistenciaException;
import utilerias.Convertidor;
import utilerias.Tabla;

public class PeliculaNegocio implements IPeliculaNegocio {

    private IPeliculaDAO peliculaDAO;
    private Convertidor convertir = new Convertidor();
    private IConexionBD conexionBD;
    private Connection cn;

    public PeliculaNegocio() {
        // Inicializamos ClienteDAO con una nueva instancia de ConexionBD
        incializar();
        IPeliculaDAO peliculaDAO = new PeliculaDAO(new ConexionBD());
        conexionBD = new ConexionBD();
    }

    private void incializar() {
        this.peliculaDAO = new PeliculaDAO(new ConexionBD());
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
    public void eliminarPelicula(int id) throws NegocioException {
        try {
            // Eliminar lógicamente la película
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            peliculaDAO.eliminarPelicula(id);
            cn.commit();
            // Convertir la Entidad eliminada a DTO
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la película", e);
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaNegocio.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public List<PeliculaDTO> buscarporNombre(String nombre, Tabla filtro) throws NegocioException {
        try {
            nombre = nombre.replaceAll("\\s+", "");
            List<PeliculaEntidad> listaEntidades = peliculaDAO.buscarporNombre(nombre, filtro);
            List<PeliculaDTO> listaDTOs = new ArrayList<>();
            for (PeliculaEntidad entidad : listaEntidades) {
                PeliculaDTO TablaDTO = convertir.EntidadaDTO(entidad);
                listaDTOs.add(TablaDTO);
            }

            return listaDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar clientes: " + e.getMessage(), e);
        }
    }

}
