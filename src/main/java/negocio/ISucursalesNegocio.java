package negocio;

import dto.SucursalDTO;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;


public interface ISucursalesNegocio {
    ArrayList<SucursalDTO> consultar() throws NegocioException;

    public void guardar(SucursalDTO sucursalDTO) throws NegocioException;

    void eliminar(String nombre) throws NegocioException;

    public List<SucursalDTO> buscarSucursales(Tabla filtro) throws NegocioException;
    
    List<SucursalDTO> buscarporNombre(String nombre, Tabla Filtro) throws NegocioException;
    
    List<SucursalDTO> buscarporDireccion(String dir, Tabla Filtro) throws NegocioException;
}
