/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.SalaDTO;
import entidad.SalaEntidad;
import java.util.ArrayList;
import java.util.List;
import persistencia.ISalaDAO;
import persistencia.PersistenciaException;
import utilerias.Tabla;

/**
 *
 * @author cesar
 */
public class SalaNegocio implements ISalaNegocio {

    private ISalaDAO salaDAO;

    public SalaNegocio(ISalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    public List<SalaDTO> consultar() throws NegocioException {
        try {
            List<SalaEntidad> salasEntidad = salaDAO.leer();
            List<SalaDTO> salasDTO = new ArrayList<>();

            // Convertir cada entidad en un DTO
            for (SalaEntidad entidad : salasEntidad) {
                SalaDTO dto = new SalaDTO(entidad.getId(), entidad.getNombre());
                salasDTO.add(dto);
            }

            return salasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar las salas", e);
        }
    }

    @Override
    public List<SalaDTO> leer() throws NegocioException {
        try {
            // Obtenemos las entidades de la base de datos
            List<SalaEntidad> entidades = salaDAO.leer();

            // Convertimos las entidades a DTOs
            List<SalaDTO> salasDTO = new ArrayList<>();
            for (SalaEntidad entidad : entidades) {
                SalaDTO dto = new SalaDTO();
                dto.setId(entidad.getId());
                dto.setNombre(entidad.getNombre());
                salasDTO.add(dto);
            }

            // Retornamos la lista de DTOs
            return salasDTO;

        } catch (PersistenciaException e) {
            // Si ocurre un error en la capa de persistencia, lanzamos una excepción de negocio
            throw new NegocioException("Error al consultar las salas", e);
        }
    }

    @Override
    public void guardar(SalaDTO salaDTO) throws NegocioException {
        try {
            // Crear la entidad a partir del DTO
            SalaEntidad entidad = new SalaEntidad();
            entidad.setNombre(salaDTO.getNombre());

            salaDAO.guardar(entidad);

            // Si necesitas devolver el ID generado, podrías agregarlo al DTO aquí:
            salaDTO.setId(entidad.getId());

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la sala", e);
        }
    }

    @Override
    public void eliminar(int idSala) throws NegocioException {
        try {
            salaDAO.eliminar(idSala);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la sala con ID: " + idSala, e);
        }
    }

    @Override
    public List<SalaDTO> buscarSalas(Tabla filtro) throws NegocioException {
        try {
            List<SalaEntidad> salasEntidad = salaDAO.buscarSalas(filtro);
            List<SalaDTO> salasDTO = new ArrayList<>();

            // Convertir cada entidad en un DTO
            for (SalaEntidad entidad : salasEntidad) {
                SalaDTO dto = new SalaDTO(entidad.getId(), entidad.getNombre());
                salasDTO.add(dto);
            }

            return salasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar las salas", e);
        }
    }

    @Override
    public SalaDTO buscarporNumero(int idSala) throws NegocioException {
        try {
            SalaEntidad entidad = salaDAO.buscarporNumero(idSala);
            if (entidad == null) {
                return null;
            }
            // Convertir la entidad en DTO
            return new SalaDTO(entidad.getId(), entidad.getNombre());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la sala con ID: " + idSala, e);
        }
    }

}
