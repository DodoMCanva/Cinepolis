package persistencia;

import dto.SalaDTO;
import entidad.ClienteEntidad;
import entidad.SalaEntidad;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;


public interface ISalaDAO {
    
    ArrayList<SalaDTO> leer() throws PersistenciaException;

    void guardar(SalaEntidad sala) throws PersistenciaException;

    void eliminar(int idSala) throws PersistenciaException;

    ClienteEntidad buscarporNumero(int n) throws PersistenciaException;

    public List<SalaEntidad> buscarSalas(Tabla filtro) throws PersistenciaException;

    public IConexionBD getConexionBD();
    
}
