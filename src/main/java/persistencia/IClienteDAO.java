package persistencia;

import entidad.ClienteEntidad;
import java.util.List;
import dto.ClienteFiltroTablaDTO;
import utilerias.Tabla;

public interface IClienteDAO {

    void guardar(ClienteEntidad cliente) throws PersistenciaException;

    void eliminar(int idCliente) throws PersistenciaException;

   String obtenerNombre(int ID_Cliente) throws PersistenciaException;

    ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException;

    public List<ClienteEntidad> buscarClientesPorFiltro(ClienteFiltroTablaDTO filtro) throws PersistenciaException;

}
