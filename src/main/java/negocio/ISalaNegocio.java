package negocio;

import dto.SalaDTO;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;


public interface ISalaNegocio {
    ArrayList<SalaDTO> consultar() throws NegocioException;

    public void guardar(SalaDTO salaDTO) throws NegocioException;

    void eliminar(int idSala) throws NegocioException;

    public List<SalaDTO> buscarSalas(Tabla filtro) throws NegocioException;
    
    List<SalaDTO> buscarporNumero(int n, Tabla Filtro) throws NegocioException;
}
