package persistencia;

import entidad.SalaEntidad;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface ISalaDAO {

    ArrayList<SalaEntidad> leer() throws PersistenciaException;

    void guardar(SalaEntidad sala, int idSucursal) throws PersistenciaException;

    void eliminar(int idSala) throws PersistenciaException;

    SalaEntidad buscarporNumero(int idSala) throws PersistenciaException;

    public List<SalaEntidad> buscarSalas(Tabla filtro, int IDS) throws PersistenciaException ;

    public IConexionBD getConexionBD();

}
