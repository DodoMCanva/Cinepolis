package utilerias;

import entidad.ClienteEntidad;
import java.sql.Timestamp;
import dto.ClienteDTO;

public class Convertidor {

    /*
    private ClienteTablaDTO transformarEntidadATablaDTO(ClienteEntidad entidad) {
        ClienteTablaDTO clienteTablaDTO = new ClienteTablaDTO();
        clienteTablaDTO.setIdClientes(entidad.getIdClientes());
        clienteTablaDTO.setNombre(entidad.getNombre());
        clienteTablaDTO.setApellidoP(entidad.getApellidoP());
        clienteTablaDTO.setApellidoM(entidad.getApellidoM());
        clienteTablaDTO.setEstaEliminado(entidad.isEstaEliminado());
        // Otros campos que necesites en la tabla...
        return clienteTablaDTO;

    }

     */
    /*
    public ClienteEnt DTOaEntidad(ClienteDTO clienteDTO) {
        ClienteEnt clienteEntidad = new ClienteEnt();
        clienteEntidad.setNombre(clienteDTO.getNombres());
        clienteEntidad.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEntidad.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEntidad.setEstaEliminado(clienteDTO.isEstaEliminado()); // Por defecto no está eliminado
        clienteEntidad.setId(clienteDTO.getIdCliente());
        clienteEntidad.setFechaHoraRegistro(new java.util.Date()); // Fecha actual
        return clienteEntidad;
    }

    public ClienteDTO EntidadaDTO(ClienteEnt clienteEntidad) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(clienteEntidad.getId());
        clienteDTO.setNombres(clienteEntidad.getNombre());
        clienteDTO.setApellidoPaterno(clienteEntidad.getApellidoPaterno());
        clienteDTO.setApellidoMaterno(clienteEntidad.getApellidoMaterno());
        clienteDTO.setFechaRegistro((Timestamp) clienteEntidad.getFechaHoraRegistro());
        clienteDTO.setEstaEliminado(clienteEntidad.isEstaEliminado());
        return clienteDTO;
    }
*/
}
