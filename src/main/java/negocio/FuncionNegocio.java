package negocio;

import dto.FuncionDTO;
import entidad.FuncionEntidad;
import java.sql.SQLException;
import java.util.List;
import persistencia.FuncionDAO;

public class FuncionNegocio implements IFuncionNegocio{
    private FuncionDAO funcionDAO;

    public FuncionNegocio(FuncionDAO funcionDAO) {
        this.funcionDAO = funcionDAO;
    }
    public FuncionNegocio() {
    
    }

    public void agregarFuncion(FuncionDTO funcionDTO) throws SQLException {
        FuncionEntidad funcion = new FuncionEntidad();
        funcion.setCosto(funcionDTO.getCosto());
        funcion.setHoraInicio(funcionDTO.getHoraInicio());
        funcion.setHoraFin(funcionDTO.getHoraFin());
        funcion.setIdPelicula(funcionDTO.getIdPelicula());
        funcion.setIdSala(funcionDTO.getIdSala());
        funcion.setEstaEliminada(false);

        funcionDAO.agregarFuncion(funcion);
    }

    public List<FuncionEntidad> obtenerFunciones() throws SQLException {
        return funcionDAO.obtenerFunciones();
    }
    
    public void eliminar(int id) throws SQLException {
        funcionDAO.eliminarFuncion(id);
    }
}
