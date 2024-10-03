package negocio;

import dto.FuncionDTO;
import java.util.List;
import utilerias.Tabla;

public interface IFuncionNegocio {

    List<FuncionDTO> consultar() throws NegocioException;

    public void guardar(FuncionDTO FuncionDTO, int idSucursal, int idPelicula, int idSala) throws NegocioException;

    void eliminar(int idSala) throws NegocioException;

    public List<FuncionDTO> buscarFunciones(Tabla filtro, int ids) throws NegocioException;

}
