package persistencia;

import dto.ClienteDTO;
import entidad.ClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    
    @Override
    public void guardar(ClienteEntidad cliente) throws PersistenciaException {
        // Consulta SQL para insertar en la tabla Cliente
        String consultaCliente = "INSERT INTO Cliente (Correo_Electronico, Fecha_Nacimiento, Geolocalizacion, Contrasena) VALUES (?, ?, ?, ?)";
        String consultaNombreCliente = "INSERT INTO NombreCliente (ID, Nombre, Apellido_Paterno, Apellido_Materno) VALUES (?, ?, ?, ?)";

        try (Connection connection = conexionBD.crearConexion()) {
            // Habilitar la generación de claves para obtener el ID del cliente insertado
            try (PreparedStatement psCliente = connection.prepareStatement(consultaCliente, Statement.RETURN_GENERATED_KEYS)) {
                // Asignamos los valores a la consulta SQL para Cliente
                psCliente.setString(1, cliente.getCorreoElectronico());
                psCliente.setString(2, cliente.getFechaNacimiento());
                psCliente.setString(3, cliente.getGeolocalizacion());
                psCliente.setString(4, cliente.getContrasena());

                // Ejecutamos la consulta para guardar el cliente
                psCliente.executeUpdate();

                // Obtener el ID del cliente insertado
                ResultSet generatedKeys = psCliente.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idCliente = generatedKeys.getInt(1); // Obtener el ID generado

                    // Ahora insertar en la tabla NombreCliente
                    try (PreparedStatement psNombreCliente = connection.prepareStatement(consultaNombreCliente)) {
                        psNombreCliente.setInt(1, idCliente); // Usar el ID generado
                        psNombreCliente.setString(2, cliente.getNombre());
                        psNombreCliente.setString(3, cliente.getApellidoPaterno());
                        psNombreCliente.setString(4, cliente.getApellidoMaterno());

                        // Ejecutar la inserción
                        psNombreCliente.executeUpdate();
                    }
                }
                System.out.println("Cliente y nombre guardados correctamente en la base de datos");
            }

        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }

     @Override
    public void eliminar(int idCliente) throws PersistenciaException {
        // La consulta SQL para marcar un cliente como eliminado.
        String consulta = "UPDATE Cliente SET estaEliminado = ? WHERE ID_Cliente = ? ";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
            System.out.println("cliente" + idCliente);
            // Marcamos el cliente como eliminado en la base de datos.
            stmt.setBoolean(1, true);
            stmt.setInt(2, idCliente);
            stmt.executeUpdate();

        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al actualizar el cliente", e);
        }
    }

    @Override
    public List<ClienteEntidad> buscarNombre(String nombre, Tabla Filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     @Override
    public ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException {
        ClienteEntidad cliente = null;
        // La consulta SQL para buscar un cliente por su ID.
        String consulta = "SELECT ID_Cliente, Nombre, Apellido_Paterno, Apellido_Materno, estaEliminado,Fecha_Nacimiento, fechaHoraRegistro,Correo_Electronico,Geolocalizacion, Contrasena FROM Cliente WHERE ID_Cliente = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
            // Asignamos el ID del cliente a la consulta.
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Creamos un nuevo objeto ClienteEntidad y le asignamos los valores obtenidos de la base de datos.
                cliente = new ClienteEntidad();
                cliente.setId(rs.getInt("idClientes"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidoP(rs.getString("ApellidoP"));
                cliente.setApellidoM(rs.getString("ApellidoM"));
                cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                cliente.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));
            }

        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaExceptions("Error al obtener el cliente con ID: " + idCliente, e);
        }

        return cliente;
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
