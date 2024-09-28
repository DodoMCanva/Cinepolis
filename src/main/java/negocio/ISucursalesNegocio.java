package negocio;

import dto.SucursalDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;


public interface ISucursalesNegocio {
    List <SucursalDTO> obtenerTodasLasSucursales(Tabla Filtro);

    public void agregarSucursal(SucursalDTO sucursalDTO) throws SQLException;

    void eliminar(int id) throws NegocioException;

    public List<SucursalDTO> buscarSucursal(Tabla filtro) throws NegocioException;
    
    List<SucursalDTO> buscarporNombre(String nombre, Tabla Filtro) throws NegocioException;
    
    List<SucursalDTO> buscarporDireccion(String dir, Tabla Filtro) throws NegocioException;
    
}
