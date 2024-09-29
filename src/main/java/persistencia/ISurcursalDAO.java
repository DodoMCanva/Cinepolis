package persistencia;

import entidad.SucursalEntidad;
import java.sql.SQLException;
import java.util.List;
import utilerias.Tabla;

public interface ISurcursalDAO {
    // ArrayList<SucursalDTO> leer() throws PersistenciaException;

    void guardar(SucursalEntidad sucursal) throws SQLException;

    void eliminar(int id) throws SQLException;

    public List<SucursalEntidad> buscarporDireccion(String dir, Tabla Filtro) throws PersistenciaException;

    List<SucursalEntidad> buscarporNombre(String nombre) throws PersistenciaException;

    int buscarIdporNombre(String nombre) throws PersistenciaException;

    public List<SucursalEntidad> buscarSucursal(Tabla filtro) throws PersistenciaException;

    List<SucursalEntidad> obtenerTodas(Tabla filtro) throws SQLException;

    List<SucursalEntidad> obtenerPorCiudad(String ciudad) throws SQLException;

    public IConexionBD getConexionBD();

}
