package persistencia;

import dto.ClienteDTO;
import entidad.ClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public class ClienteDAO implements IClienteDAO{
private IConexionBD conexionBD;

 
    @Override
    public ArrayList<ClienteDTO> leer() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
    public void guardar(ClienteEntidad cliente) throws PersistenciaException {
        // La consulta SQL para insertar un nuevo cliente en la base de datos.
        String consulta = "INSERT INTO Clientes (Nombre, Apellido_Paterno, Apellido_Materno,Correo_Eletronico,Fecha_Nacimiento,Geolocalizacion,estaEliminado, fechaHoraRegistro) VALUES (?, ?, ?, ?, ?,?,?,?)";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            // Asignamos los valores a la consulta SQL.
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getFechaNacimiento());
            ps.setBoolean(6, cliente.isEstaEliminado());
            ps.setTimestamp(7, new java.sql.Timestamp(cliente.getFechaHoraRegistro().getTime()));

            // Ejecutamos la consulta para guardar el cliente.
            ps.executeUpdate();
            System.out.println("Cliente guardado correctamente en la base de datos");

        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }


    @Override
    public void eliminar(int idCliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteEntidad> buscarNombre(String nombre, Tabla Filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteEntidad> buscarClientes(Tabla filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IConexionBD getConexionBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
