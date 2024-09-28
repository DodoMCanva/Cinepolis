package negocio;

import dto.ClienteDTO;
import entidad.ClienteEntidad;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import persistencia.PersistenciaException;
import utilerias.Convertidor;
import utilerias.Tabla;

public class ClienteNegocio implements IClienteNegocio {

    private Convertidor convertir = new Convertidor();
    private IClienteDAO clienteDAO;
    private IConexionBD conexionBD;
    private Connection cn;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
        conexionBD = clienteDAO.getConexionBD();

    }

    public ClienteNegocio() {
    }

    //Consultas
    @Override
    public ArrayList<ClienteDTO> consultar() throws NegocioException {
        try {
            return clienteDAO.leer();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al leer los clientes desde la base de datos", e);
        }
    }

    @Override
    public ClienteDTO obtenerClientePorId(int id) throws NegocioException {
        try {
            ClienteEntidad clienteEntity = clienteDAO.buscarPorId(id);
            return convertir.EntidadaDTO(clienteEntity);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el cliente por ID", e);
        }
    }

    @Override
    public List<ClienteDTO> buscarporNombre(String nombre, Tabla Filtro) throws NegocioException {
        try {
            List<ClienteEntidad> listaEntidades = clienteDAO.buscarNombre(nombre, Filtro);
            List<ClienteDTO> listaDTOs = new ArrayList<>();
            for (ClienteEntidad entidad : listaEntidades) {
                ClienteDTO clienteTablaDTO = convertir.EntidadaDTO(entidad);
                listaDTOs.add(clienteTablaDTO);
            }

            return listaDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar clientes: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ClienteDTO> buscarClientes(Tabla filtro) throws NegocioException {
        try {
            List<ClienteEntidad> listaEntidades = clienteDAO.buscarClientes(filtro);
            List<ClienteDTO> listaDTOs = new ArrayList<>();
            for (ClienteEntidad entidad : listaEntidades) {
                ClienteDTO clienteTablaDTO = convertir.EntidadaDTO(entidad);
                listaDTOs.add(clienteTablaDTO);
            }

            return listaDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar clientes: " + e.getMessage(), e);
        }
    }

    //Modificaciones
    @Override
    public void guardar(ClienteDTO clienteDTO) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            ClienteEntidad Entidad = convertir.DTOaEntidad(clienteDTO);
            if (reglasNegocio(clienteDTO)) {
                this.clienteDAO.guardar(Entidad);
                cn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar el cliente en la base de datos", e);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void eliminar(int idCliente) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            this.clienteDAO.eliminar(idCliente);
            cn.commit();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente: " + e.getMessage(), e);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean reglasNegocio(ClienteDTO e) {
        String Nombre_Completo = e.getNombre()+ e.getApellidoPaterno() + e.getApellidoMaterno();
        if (Nombre_Completo.matches(".*\\d.*") || Nombre_Completo.contains("Panduro")) {
            return false;
        } else {
            return true;
        }
    }
    
    public ClienteDTO autenticarCliente(ClienteDTO clienteDTO) throws NegocioException {
            // Convertir el DTO a entidad si es necesario en el DAO
            ClienteEntidad clienteEntidad = new ClienteEntidad(); // Si tienes un método de conversión

            clienteEntidad.setCorreoElectronico(clienteDTO.getCorreoElectronico());
            clienteEntidad.setContrasena(clienteDTO.getContrasena());

            try {
                // Llamar al DAO para buscar el cliente por correo y contraseña
                ClienteEntidad clienteEncontrado = clienteDAO.buscarPorCorreoYContrasena(
                        clienteEntidad.getCorreoElectronico(),
                        clienteEntidad.getContrasena()
                );

                if (clienteEncontrado != null) {
                    // Convertir de entidad a DTO para devolver
                    clienteDTO.setId(clienteEncontrado.getId());
                    clienteDTO.setNombre(clienteEncontrado.getNombre());
                    // Rellenar otros campos que necesites del DTO si es necesario

                    return clienteDTO; // Retornar el DTO del cliente autenticado
                } else {
                    return null; // Si no se encontró, retornar null
                }
            } catch (PersistenciaException e) {
                throw new NegocioException("Error al autenticar el cliente", e);
            }
        }
}
