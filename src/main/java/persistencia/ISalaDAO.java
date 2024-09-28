package persistencia;

import entidad.SalaEntidad;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface ISalaDAO {

    ArrayList<SalaEntidad> leer() throws PersistenciaException;

    void guardar(SalaEntidad sala) throws PersistenciaException;

    void eliminar(int idSala) throws PersistenciaException;

    SalaEntidad buscarporNumero(int idSala) throws PersistenciaException;

    public List<SalaEntidad> buscarSalas(Tabla filtro) throws PersistenciaException;

    public IConexionBD getConexionBD();

}
