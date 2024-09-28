package utilerias;

import entidad.ClienteEntidad;
import java.sql.Timestamp;
import dto.ClienteDTO;
import java.util.Date;

public class Convertidor {

    public ClienteEntidad DTOaEntidad(ClienteDTO clienteDTO) {
        ClienteEntidad clienteEntidad = new ClienteEntidad();
        clienteEntidad.setNombre(clienteDTO.getNombre());
        clienteEntidad.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEntidad.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEntidad.setCelular(clienteDTO.getCelular());
        clienteEntidad.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteEntidad.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        clienteEntidad.setContrasena(clienteDTO.getContrasena());
        clienteEntidad.setFechaHoraRegistro(new Date()); 
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
