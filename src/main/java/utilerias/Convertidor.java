package utilerias;

import entidad.ClienteEntidad;
import java.sql.Timestamp;
import dto.ClienteDTO;

public class Convertidor {

    public ClienteEntidad DTOaEntidad(ClienteDTO clienteDTO) {
        ClienteEntidad clienteEntidad = new ClienteEntidad();
        clienteEntidad.setNombre(clienteDTO.getNombre());
        clienteEntidad.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEntidad.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEntidad.setEstaEliminado(clienteDTO.isEstaEliminado()); // Por defecto no está eliminado
        clienteEntidad.setId(clienteDTO.getId());
        clienteEntidad.setFechaHoraRegistro(new java.util.Date()); // Fecha actual
        return clienteEntidad;
    }

    public ClienteDTO EntidadaDTO(ClienteEntidad clienteEntidad) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteEntidad.getId());
        clienteDTO.setNombre(clienteEntidad.getNombre());
        clienteDTO.setApellidoPaterno(clienteEntidad.getApellidoPaterno());
        clienteDTO.setApellidoMaterno(clienteEntidad.getApellidoMaterno());
        clienteDTO.setFechaHoraRegistro((Timestamp) clienteEntidad.getFechaHoraRegistro());
        clienteDTO.setEstaEliminado(clienteEntidad.isEstaEliminado());
        return clienteDTO;
    }

}
