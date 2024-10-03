package persistencia;

import entidad.FuncionEntidad;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface IFuncionDAO {

    ArrayList<FuncionEntidad> leer() throws PersistenciaException;

    public void guardar(FuncionEntidad f, int idSucursal, int idPelicula, int idSala) throws PersistenciaException;

    void eliminar(int idFuncion) throws PersistenciaException;

    public List<FuncionEntidad> buscarFunciones(Tabla filtro, int IDS) throws PersistenciaException;

    public IConexionBD getConexionBD();
}
