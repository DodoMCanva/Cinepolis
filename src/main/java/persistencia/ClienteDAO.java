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
import javax.swing.JOptionPane;
import utilerias.Tabla;

public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    

    @Override
    public void guardar(ClienteEntidad cliente) throws PersistenciaException {
        // Consulta SQL para insertar en la tabla Cliente
        String consultaCliente = "INSERT INTO Clientes (correoElectronico, fechaNacimiento, geolcl, psswrd, celular) VALUES (?, ?, ?, ?, ?)";
        String consultaNombreCliente = "INSERT INTO NombreCliente (ID, nombre, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?, ?)";

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
        String consulta = "UPDATE Clientes SET estaEliminado = ? WHERE ID_Cliente = ? ";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
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
        String consulta = "SELECT nombre, apellidoPaterno, apellidoMaterno FROM NombreCliente WHERE ID = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
            // Asignamos el ID del cliente a la consulta.
            stmt.setInt(1, ID_Cliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtenemos los valores del nombre y apellidos
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apellidoMaterno = rs.getString("apellidoMaterno");

                // Combinamos el nombre completo
                nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
            }
        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al obtener el nombre del cliente con ID: " + ID_Cliente, e);
        }

        return nombreCompleto;
    }

    @Override
    public ClienteEntidad buscarPorCorreoYContrasena(String correo, String contrasena) throws PersistenciaException {
        // Consulta SQL seleccionando solo los campos requeridos
        String consulta = "SELECT correoElectronico, psswrd "
                + "FROM Clientes WHERE correoElectronico = ? AND psswrd = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si hay resultados, creamos y devolvemos un ClienteEntidad
                    ClienteEntidad cliente = new ClienteEntidad();

                    cliente.setCorreoElectronico(rs.getString("correoElectronico"));
                    cliente.setContrasena(rs.getString("psswrd"));

                    return cliente; // Retornar el cliente encontrado
                } else {
                    return null; // No se encontró el cliente
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar el cliente", e);
        }
    }

    //??
    @Override
    public ClienteEntidad buscarPorId(int idCliente) throws PersistenciaException {
        ClienteEntidad cliente = null;
        // La consulta SQL para buscar un cliente por su ID.
        String consulta = "SELECT ID_Cliente, Nombre, apellidoPaterno, apellidoaMaterno, estaEliminado,Fecha_Nacimiento, fechaHoraRegistro,Correo_Electronico,Geolocalizacion, Contrasena FROM Cliente WHERE ID_Cliente = ?";

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
    public IConexionBD getConexionBD() {
        return conexionBD;
    }

    @Override
    public List<ClienteEntidad> buscarNombre(String nombre, Tabla filtro) throws PersistenciaException {
        List<ClienteEntidad> listaClientes = new ArrayList<>();

        // Consulta con JOIN entre Clientes y NombreCliente para buscar por nombre y obtener toda la información
        String consulta = "SELECT c.ID_Cliente, nc.nombre, nc.apellidoPaterno, nc.apellidoMaterno, c.estaEliminado, "
                + "c.fechaNacimiento, c.fechaRegistro, c.correoElectronico, c.celular, c.geolcl, c.psswrd "
                + "FROM Clientes c "
                + "JOIN NombreCliente nc ON c.ID_Cliente = nc.ID "
                + "WHERE c.estaEliminado = false " // Solo los que no están eliminados
                + "AND (nc.nombre LIKE ? OR nc.apellidoPaterno LIKE ? OR nc.apellidoMaterno LIKE ?) " // Búsqueda por nombre o apellidos
                + "LIMIT ? OFFSET ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            String nombreBusqueda = "%" + nombre + "%";

            // Asignamos los valores del filtro a la consulta SQL.
            ps.setString(1, nombreBusqueda);  // Búsqueda por nombre
            ps.setString(2, nombreBusqueda);  // Búsqueda por apellido paterno
            ps.setString(3, nombreBusqueda);  // Búsqueda por apellido materno
            ps.setInt(4, filtro.getLimite());  // Límite de resultados
            ps.setInt(5, filtro.getPagina() * filtro.getLimite());  // Offset para la paginación

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Creamos un nuevo objeto ClienteEntidad y le asignamos los valores obtenidos de la base de datos.
                    ClienteEntidad cliente = new ClienteEntidad();
                    cliente.setId(rs.getInt("ID_Cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    cliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                    cliente.setCorreoElectronico(rs.getString("correoElectronico"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setGeolocalizacion(rs.getString("geolcl"));
                    cliente.setContrasena(rs.getString("psswrd"));
                    cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                    cliente.setFechaHoraRegistro(rs.getTimestamp("fechaRegistro"));

                    // Añadimos el cliente a la lista
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al buscar clientes", e);
        }
        return listaClientes;

    }

    @Override
    public List<ClienteEntidad> buscarClientes(Tabla filtro) throws PersistenciaException {
        List<ClienteEntidad> listaClientes = new ArrayList<>();

        String consulta = "SELECT c.ID_Cliente, nc.nombre, nc.apellidoPaterno, nc.apellidoMaterno, c.estaEliminado, "
                + "c.fechaNacimiento, c.fechaRegistro, c.correoElectronico, c.celular, c.geolcl, c.psswrd "
                + "FROM Clientes c "
                + "JOIN NombreCliente nc ON c.ID_Cliente = nc.ID "
                + "WHERE c.estaEliminado = false "
                + "LIMIT ? OFFSET ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            ps.setInt(1, filtro.getLimite());  // Límite de resultados
            ps.setInt(2, filtro.getPagina() * filtro.getLimite());  // Offset para la paginación

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Creamos un nuevo objeto ClienteEntidad y le asignamos los valores obtenidos de la base de datos.
                    ClienteEntidad cliente = new ClienteEntidad();
                    cliente.setId(rs.getInt("c.ID_Cliente"));
                    cliente.setNombre(rs.getString("nc.nombre"));
                    cliente.setApellidoPaterno(rs.getString("nc.apellidoPaterno"));
                    cliente.setApellidoMaterno(rs.getString("nc.apellidoMaterno"));
                    cliente.setFechaNacimiento(rs.getString("c.fechaNacimiento"));
                    cliente.setCorreoElectronico(rs.getString("c.correoElectronico"));
                    cliente.setCelular(rs.getString("c.celular"));
                    cliente.setGeolocalizacion(rs.getString("c.geolcl"));
                    cliente.setContrasena(rs.getString("c.psswrd"));
                    cliente.setEstaEliminado(rs.getBoolean("c.estaEliminado"));
                    cliente.setFechaHoraRegistro(rs.getTimestamp("c.fechaRegistro"));

                    // Añadimos el cliente a la lista
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            // Si ocurre un error, lanzamos una excepción con un mensaje.
            throw new PersistenciaException("Error al buscar clientes", e);
        }
        return listaClientes;
    }

}
