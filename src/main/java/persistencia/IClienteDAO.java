package persistencia;

import entidad.ClienteEntidad;
import java.util.ArrayList;
import java.util.List;
import dto.ClienteDTO;
import utilerias.Tabla;

public interface IClienteDAO {

    void guardar(ClienteEntidad cliente) throws PersistenciaException;

    void eliminar(int idCliente) throws PersistenciaException;

    public List<ClienteEntidad> buscarNombre(String nombre, Tabla Filtro) throws PersistenciaException ;

    ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException;

    public List<ClienteEntidad> buscarClientes(Tabla filtro) throws PersistenciaException;

    public IConexionBD getConexionBD();

}
