package negocio;

import dto.SucursalDTO;
import entidad.SucursalEntidad;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IConexionBD;
import persistencia.ISurcursalDAO;
import persistencia.PersistenciaException;
import persistencia.SucursalDAO;
import utilerias.Tabla;

public class SucursalNegocio implements ISucursalesNegocio {

    private ISurcursalDAO sucursalDAO;
    private IConexionBD conexionBD;

    public SucursalNegocio() {
        incializar();
        ISurcursalDAO sucursalDAO = new SucursalDAO(new ConexionBD());
        conexionBD = sucursalDAO.getConexionBD();
    }

    private void incializar() {
        this.sucursalDAO = new SucursalDAO(new ConexionBD());
    }

    @Override
    public List<SucursalDTO> obtenerTodasLasSucursales(Tabla filtro) {
        try {
            List<SucursalEntidad> sucursales = sucursalDAO.obtenerTodas(filtro);
            return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todas las sucursales", e);
        }
    }

    // Método para obtener sucursales por ciudad
    public List<SucursalDTO> obtenerSucursalesPorCiudad(String ciudad) {
        try {
            List<SucursalEntidad> sucursales = sucursalDAO.obtenerPorCiudad(ciudad);
            return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener sucursales por ciudad", e);
        }
    }

    // Método para convertir la entidad a DTO
    private SucursalDTO convertirEntidadADTO(SucursalEntidad sucursalEntidad) {
        SucursalDTO dto = new SucursalDTO();
        dto.setNombre(sucursalEntidad.getNombre());
        dto.setEstado(sucursalEntidad.getEstado());
        dto.setCiudad(sucursalEntidad.getCiudad());
        dto.setCalle(sucursalEntidad.getCalle());
        dto.setCodigoPostal(sucursalEntidad.getCodigoPostal());
        dto.setEstaEliminado(sucursalEntidad.isEstaEliminado());
        dto.setFechaHoraRegistro(sucursalEntidad.getFechaHoraRegistro());
        return dto;
    }

    // Método para agregar una nueva sucursal
    @Override
    public void agregarSucursal(SucursalDTO sucursalDTO) throws SQLException {
        SucursalEntidad nuevaSucursal = convertirDTOAEntidad(sucursalDTO);
        sucursalDAO.guardar(nuevaSucursal);
    }

    // Método para convertir el DTO a entidad
    private SucursalEntidad convertirDTOAEntidad(SucursalDTO dto) {
        SucursalEntidad entidad = new SucursalEntidad();
        entidad.setNombre(dto.getNombre());
        entidad.setEstado(dto.getEstado());
        entidad.setCiudad(dto.getCiudad());
        entidad.setCalle(dto.getCalle());
        entidad.setCodigoPostal(dto.getCodigoPostal());
        entidad.setEstaEliminado(dto.isEstaEliminado());
        entidad.setFechaHoraRegistro(dto.getFechaHoraRegistro());
        return entidad;
    }

    @Override
    public void eliminar(int id) {
        try {
            sucursalDAO.eliminar(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la sucursal", e);
        }
    }

    @Override
    public List<SucursalDTO> buscarSucursal(Tabla filtro) throws NegocioException {
        try {
            // Implementación de la lógica para usar el filtro y buscar sucursales
            List<SucursalEntidad> sucursales = sucursalDAO.buscarSucursal(filtro);

            // Convertir las entidades a DTO
            return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());

        } catch (PersistenciaException ex) {
            // Registrar el error y lanzar una excepción de negocio
            Logger.getLogger(SucursalNegocio.class.getName()).log(Level.SEVERE, "Error en buscarSucursal", ex);

            // Lanza una excepción personalizada para que otras capas la manejen
            throw new NegocioException("Error al buscar sucursales con el filtro especificado", ex);
        }
    }

    @Override
    public List<SucursalDTO> buscarporNombre(String nombre, Tabla filtro) throws NegocioException {
        try {
            List<SucursalEntidad> sucursales = (List<SucursalEntidad>) sucursalDAO.buscarporNombre(nombre);
            return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar sucursales por nombre", ex);
        }
    }

    @Override
    public List<SucursalDTO> buscarporDireccion(String dir, Tabla filtro) throws NegocioException {
        try {
            List<SucursalEntidad> sucursales = sucursalDAO.buscarporDireccion(dir, filtro);
            return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar sucursales por dirección", ex);
        }
    }
}
