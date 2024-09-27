package persistencia;

import dto.FiltroTablaDTO;
import entidad.ClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(ClienteEntidad cliente) throws PersistenciaException {
        // Consulta SQL para insertar en la tabla Cliente
        String consultaCliente = "INSERT INTO Clientes (correoElectronico, fechaNacimiento, geolcl, psswrd, celular) VALUES (?, ?, ?, ?, ?)";
        String consultaNombreCliente = "INSERT INTO NombreCliente (ID, Nombre, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?, ?)";

        try (Connection connection = conexionBD.crearConexion()) {
            // Habilitar la generación de claves para obtener el ID del cliente insertado
            try (PreparedStatement psCliente = connection.prepareStatement(consultaCliente, Statement.RETURN_GENERATED_KEYS)) {
                // Asignamos los valores a la consulta SQL para Cliente
                psCliente.setString(1, cliente.getCorreoElectronico());
                psCliente.setString(2, cliente.getFechaNacimiento());
                psCliente.setString(3, cliente.getGeolocalizacion());
                psCliente.setString(4, cliente.getContrasena());
                psCliente.setString(5, cliente.getCelular());

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
    public String obtenerNombre(int ID_Cliente) throws PersistenciaException {
        String nombreCompleto = null;
        // Consulta SQL para buscar el nombre completo del cliente por su ID
        String consulta = "SELECT Nombre, Apellido_Paterno, Apellido_Materno FROM NombreCliente WHERE ID = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
            // Asignamos el ID del cliente a la consulta.
            stmt.setInt(1, ID_Cliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtenemos los valores del nombre y apellidos
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("Apellido_Paterno");
                String apellidoMaterno = rs.getString("Apellido_Materno");

                // Combinamos el nombre completo
                nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
            }
        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al obtener el nombre del cliente con ID: " + ID_Cliente, e);
        }

        return nombreCompleto;
    }

    public ClienteEntidad buscarPorNombreYContrasena(String nombre, String contrasena) throws PersistenciaException {
        // Consulta SQL sin abreviaciones y seleccionando solo los campos requeridos
        String consulta = "SELECT Clientes.ID_Cliente, Clientes.correoElectronico, Clientes.fechaNacimiento, Clientes.geolocalizacion, "
                + "Clientes.contrasena, Clientes.celular, Clientes.estaEliminado, Clientes.fechaRegistro, "
                + "NombreCliente.Nombre, NombreCliente.apellidoPaterno, NombreCliente.apellidoMaterno "
                + "FROM Clientes "
                + "JOIN NombreCliente ON Clientes.ID_Cliente = NombreCliente.ID "
                + "WHERE NombreCliente.Nombre = ? AND Clientes.contrasena = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            ps.setString(1, nombre);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si hay resultados, creamos y devolvemos un ClienteEntidad
                    ClienteEntidad cliente = new ClienteEntidad();
                    cliente.setId(rs.getInt("ID_Cliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    cliente.setCorreoElectronico(rs.getString("correoElectronico"));
                    cliente.setGeolocalizacion(rs.getString("geolocalizacion"));
                    cliente.setContrasena(rs.getString("contrasena"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                    cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                    cliente.setFechaHoraRegistro(rs.getDate("fechaRegistro"));

                    return cliente; // Retornar el cliente encontrado
                } else {
                    return null; // No se encontró el cliente
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar el cliente", e);
        }
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
                cliente.setId(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidoPaterno(rs.getString("Apellido_Paterno"));
                cliente.setApellidoMaterno(rs.getString("Apellido_Materno"));
                cliente.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
                cliente.setCorreoElectronico(rs.getString("Correo"));
                cliente.setGeolocalizacion(rs.getString("Geolocalizacion"));
                cliente.setContrasena(rs.getString("Contrasena"));
                cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                cliente.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));
            }

        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al obtener el cliente con ID: " + idCliente, e);
        }

        return cliente;
    }

    @Override
    public List<ClienteEntidad> buscarClientesPorFiltro(FiltroTablaDTO filtro) throws PersistenciaException {
        List<ClienteEntidad> listaClientes = new ArrayList<>();
        // La consulta SQL para buscar clientes con un filtro específico.
        String consulta = "SELECT ID_Cliente, Nombre, Apellido_Paterno, Apellido_Materno, estaEliminado,"
                + "Fecha_Nacimiento, fechaHoraRegistro,Correo_Electronico,Geolocalizacion, Contrasena from Clientes where Nombre LIKE ? LIMIT ? OFFSET ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {

            // Asignamos los valores del filtro a la consulta SQL.
            ps.setString(1, "%" + filtro.getTextoBusqueda() + "%"); // Filtro de búsqueda por nombre
            ps.setInt(2, filtro.getLimite());  // Límite de resultados
            ps.setInt(3, filtro.getPagina() * filtro.getLimite()); // Offset para la paginación

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Creamos un nuevo objeto ClienteEntidad y le asignamos los valores obtenidos de la base de datos.
                    ClienteEntidad cliente = new ClienteEntidad();
                    cliente.setId(rs.getInt("ID_Cliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidoPaterno(rs.getString("Apellido_Paterno"));
                    cliente.setApellidoMaterno(rs.getString("Apellido_Materno"));
                    cliente.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
                    cliente.setCorreoElectronico(rs.getString("Correo"));
                    cliente.setGeolocalizacion(rs.getString("Geolocalizacion"));
                    cliente.setContrasena(rs.getString("Contrasena"));
                    cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                    cliente.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));
                }
            }
        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al buscar clientes", e);
        }

        return listaClientes;
    }

}
