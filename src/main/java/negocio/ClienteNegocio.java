package negocio;

import dto.ClienteDTO;
import entidad.ClienteEntidad;
import java.util.ArrayList;
import java.util.List;
import persistencia.ClienteDAO;
import persistencia.IClienteDAO;
import persistencia.PersistenciaException;
import utilerias.Tabla;

public class ClienteNegocio implements IClienteNegocio{

    @Override
    public ArrayList<ClienteDTO> consultar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public void guardarCliente(ClienteDTO clienteDTO) throws NegocioException {
    try {
        ClienteEntidad clienteEntidad = convertirDtoAEntidad(clienteDTO);
        IClienteDAO clienteDAO = new ClienteDAO(); // Instancia del DAO
        clienteDAO.guardar(clienteEntidad); // Guarda el cliente en la base de datos
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al guardar el cliente.", e);
    }
}

    @Override
    public void eliminar(int idCliente) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDTO> buscarClientes(Tabla filtro) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO obtenerClientePorId(int id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDTO> buscarporNombre(String nombre, Tabla Filtro) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
      private ClienteEntidad convertirDtoAEntidad(ClienteDTO clienteDTO) {
        ClienteEntidad clienteEntidad = new ClienteEntidad();
        clienteEntidad.setNombre(clienteDTO.getNombre());
        clienteEntidad.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEntidad.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEntidad.setCelular(clienteDTO.getCelular());
        clienteEntidad.setCorreoElectronico(clienteDTO.getCorreoElectronico());
            clienteEntidad.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        clienteEntidad.setContrasena(clienteDTO.getContrasena());
        return clienteEntidad;
    }

}
