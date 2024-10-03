package utilerias;

import entidad.ClienteEntidad;
import java.sql.Timestamp;
import dto.ClienteDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import entidad.FuncionEntidad;
import entidad.PeliculaEntidad;
import java.util.Date;

public class Convertidor {

    public ClienteEntidad DTOaEntidad(ClienteDTO clienteDTO) {
        ClienteEntidad clienteEntidad = new ClienteEntidad();
        clienteEntidad.setId(clienteDTO.getId());
        clienteEntidad.setNombre(clienteDTO.getNombre());
        clienteEntidad.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEntidad.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEntidad.setCelular(clienteDTO.getCelular());
        clienteEntidad.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteEntidad.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        clienteEntidad.setContrasena(clienteDTO.getContrasena());
        clienteEntidad.setFechaHoraRegistro(clienteDTO.getFechaHoraRegistro()); 
        clienteEntidad.setEstaEliminado(clienteDTO.isEstaEliminado());
        return clienteEntidad;
    }

    public ClienteDTO EntidadaDTO(ClienteEntidad clienteEntidad) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteEntidad.getId());
        clienteDTO.setNombre(clienteEntidad.getNombre());
        clienteDTO.setApellidoPaterno(clienteEntidad.getApellidoPaterno());
        clienteDTO.setApellidoMaterno(clienteEntidad.getApellidoMaterno());
        clienteDTO.setCelular(clienteEntidad.getCelular());
        clienteDTO.setCorreoElectronico(clienteEntidad.getCorreoElectronico());
        clienteDTO.setFechaNacimiento(clienteEntidad.getFechaNacimiento());
        clienteDTO.setContrasena(clienteEntidad.getContrasena());
        clienteDTO.setFechaHoraRegistro(clienteEntidad.getFechaHoraRegistro());
        clienteDTO.setEstaEliminado(clienteEntidad.isEstaEliminado());
        return clienteDTO;
        
    }
    
    public PeliculaDTO EntidadaDTO(PeliculaEntidad entidad) {
        return new PeliculaDTO(
                entidad.getId(),
                entidad.getTitulo(),
                entidad.getClasificacion(),
                entidad.getDuracion(),
                entidad.getGenero(),
                entidad.getPaisOrigen(),
                entidad.getSinopsis(),
                entidad.getLinkTrailer(),
                entidad.isEstaEliminada(),
                entidad.getPoster()
        );
    }

    public PeliculaEntidad DTOaEntidad(PeliculaDTO dto) {
        return new PeliculaEntidad(
                dto.getId(),
                dto.getTitulo(),
                dto.getClasificacion(),
                dto.getDuracion(),
                dto.getGenero(),
                dto.getPaisOrigen(),
                dto.getSinopsis(),
                dto.getLinkTrailer(),
                dto.isEstaEliminada(),
                dto.getPoster()
        );
    }
    public FuncionDTO EntidadaDTO(FuncionEntidad entidad) {
        return new FuncionDTO(
                entidad.getID(), 
                entidad.getCosto(), 
                entidad.getHoraInicio(), 
                entidad.getHoraFin(), 
                entidad.getIdPelicula(), 
                entidad.getIdSucursal(), 
                entidad.getIdSala(), 
                entidad.isEstaEliminado(), 
                entidad.getFechaHoraRegistro());
    }

    public FuncionEntidad DTOaEntidad(FuncionDTO dto) {
        return new FuncionEntidad(
                dto.getID(), 
                dto.getCosto(), 
                dto.getHoraInicio(), 
                dto.getHoraFin(), 
                dto.getIdPelicula(), 
                dto.getIdSucursal(), 
                dto.getIdSala(), 
                dto.isEstaEliminado(), 
                dto.getFechaHoraRegistro());
    }

}
