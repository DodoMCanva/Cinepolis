package negocio;

import dto.SucursalDTO;
import entidad.SucursalEntidad;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.SucursalDAO;
import utilerias.Tabla;


public class SucursalNegocio implements ISucursalesNegocio {

    private final SucursalDAO sucursalDAO;

    public SucursalNegocio(SucursalDAO sucursalDAO) {
        this.sucursalDAO = sucursalDAO;
    }

    // Método para obtener todas las sucursales
    @Override
    public List<SucursalDTO> obtenerTodasLasSucursales() {
        try {
            List<SucursalEntidad> sucursales = sucursalDAO.obtenerTodas();
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
        // Aquí puedes implementar la lógica para usar el filtro y buscar sucursales
        // Suponiendo que `filtro` tiene un método que devuelve criterios de búsqueda
        List<SucursalEntidad> sucursales = sucursalDAO.buscarSucursal(filtro);
        return sucursales.stream()
                         .map(this::convertirEntidadADTO)
                         .collect(Collectors.toList());
    } catch (SQLException e) {
        throw new NegocioException("Error al buscar sucursales", e);
    }
}
    @Override
   public List<SucursalDTO> buscarporNombre(String nombre, Tabla filtro) throws NegocioException {
    try {
        List<SucursalEntidad> sucursales = sucursalDAO.buscarporNombre(nombre);
        return sucursales.stream()
                         .map(this::convertirEntidadADTO)
                         .collect(Collectors.toList());
    } catch (SQLException e) {
        throw new NegocioException("Error al buscar sucursales por nombre", e);
    }
}

   @Override
public List<SucursalDTO> buscarporDireccion(String dir, Tabla filtro) throws NegocioException {
    try {
        List<SucursalEntidad> sucursales = sucursalDAO.buscarporDireccion(dir, filtro);
        return sucursales.stream().map(this::convertirEntidadADTO).collect(Collectors.toList());
    } catch (SQLException e) {
        throw new NegocioException("Error al buscar sucursales por dirección", e);
    }   catch (PersistenciaException ex) {
            Logger.getLogger(SucursalNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}

