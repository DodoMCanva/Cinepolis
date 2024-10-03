package negocio;

import dto.FuncionDTO;
import entidad.FuncionEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.FuncionDAO;
import persistencia.PersistenciaException;
import utilerias.Convertidor;
import utilerias.Tabla;

public class FuncionNegocio implements IFuncionNegocio {

    private FuncionDAO funcionDAO = new FuncionDAO();
    ;
    private int idSucursal;
    private Convertidor convertir = new Convertidor();

    public FuncionNegocio(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public List<FuncionDTO> consultar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(FuncionDTO FuncionDTO, int idSucursal, int idPelicula, int idSala) throws NegocioException {
        try {
            FuncionEntidad entidad = new FuncionEntidad();
            entidad = convertir.DTOaEntidad(FuncionDTO);
            funcionDAO.guardar(entidad, idSucursal, idPelicula, idSala);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la sala", e);
        }
        if (idSucursal <= 0) {
            throw new NegocioException("ID de sucursal no válido: " + idSucursal);
        }
    }

    @Override
    public List<FuncionDTO> buscarFunciones(Tabla filtro, int ids) throws NegocioException {
        try {
            List<FuncionEntidad> salasEntidad = funcionDAO.buscarFunciones(filtro, ids);
            List<FuncionDTO> funcionesDTO = new ArrayList<>();
            for (FuncionEntidad entidad : salasEntidad) {
                FuncionDTO dto = convertir.EntidadaDTO(entidad);
                funcionesDTO.add(dto);
            }
            return funcionesDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar las Funciones", e);
        }
    }

    @Override
    public void eliminar(int idSala) throws NegocioException {
        try {
            funcionDAO.eliminar(idSala);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la Funcion con ID: " + idSala, e);
        }
    }
}
