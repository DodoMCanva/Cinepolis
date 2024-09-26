package persistencia;

import dto.SucursalDTO;
import entidad.SucursalEntidad;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface ISurcursalDAO {
    ArrayList<SucursalDTO> leer() throws PersistenciaException;

    void guardar(SucursalEntidad sucursal) throws PersistenciaException;

    void eliminar(String nombre) throws PersistenciaException;

    public List<SucursalEntidad> buscarporDireccion(String dir, Tabla Filtro) throws PersistenciaException ;

    SucursalEntidad buscarporNombre(String nombre) throws PersistenciaException;

    public List<SucursalEntidad> buscarSucursal(Tabla filtro) throws PersistenciaException;

    public IConexionBD getConexionBD();
}
