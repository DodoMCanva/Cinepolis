/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import dto.ClienteDTO;
import utilerias.Tabla;

public interface IClienteNegocio {

    ArrayList<ClienteDTO> consultar() throws NegocioException;

    public void guardar(ClienteDTO clienteDTO) throws NegocioException;

    void eliminar(int idCliente) throws NegocioException;

    public List<ClienteDTO> buscarClientes(Tabla filtro) throws NegocioException;
    
    public ClienteDTO obtenerClientePorId(int id) throws NegocioException;

    List<ClienteDTO> buscarporNombre(String nombre, Tabla Filtro) throws NegocioException;

}
