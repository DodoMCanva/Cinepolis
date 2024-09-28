package persistencia;

import dto.ClienteDTO;
import entidad.ClienteEntidad;
import java.util.List;
import java.util.ArrayList;
import utilerias.Tabla;

public interface IClienteDAO {


    void guardar(ClienteEntidad cliente) throws PersistenciaException;

    void eliminar(int idCliente) throws PersistenciaException;

    public List<ClienteEntidad> buscarNombre(String nombre, Tabla Filtro) throws PersistenciaException ;

    ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException;

    public List<ClienteEntidad> buscarClientes(Tabla filtro) throws PersistenciaException;

    public IConexionBD getConexionBD();
    
    //** nuevo
    String obtenerNombre(int ID_Cliente) throws PersistenciaException;

    ClienteEntidad buscarPorCorreoYContrasena(String nombre, String contrasena) throws PersistenciaException;


}
