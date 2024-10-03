package negocio;

import dto.SalaDTO;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public interface ISalaNegocio {

    List<SalaDTO> leer() throws NegocioException;

    List<SalaDTO> consultar() throws NegocioException;

    public void guardar(SalaDTO salaDTO, int idSucursal) throws NegocioException;

    void eliminar(int idSala) throws NegocioException;

    public List<SalaDTO> buscarSalas(Tabla filtro, int ids) throws NegocioException;

    SalaDTO buscarporNumero(int idSala) throws NegocioException;


}
