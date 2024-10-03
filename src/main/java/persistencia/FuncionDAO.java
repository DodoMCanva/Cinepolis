package persistencia;

import entidad.FuncionEntidad;
import entidad.FuncionEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilerias.Tabla;

public class FuncionDAO implements IFuncionDAO {

    private IConexionBD conexionBD = new ConexionBD();

    public FuncionDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public FuncionDAO() {
    }
    

    @Override
    public ArrayList<FuncionEntidad> leer() throws PersistenciaException {
        ArrayList<FuncionEntidad> salas = new ArrayList<>();
        String consulta = "SELECT ID, costo, horaInicio, horaFin, ID_Pelicula, ID_Sucursal, ID_Sala, estaEliminada, fechaRegistro FROM Funciones";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FuncionEntidad f = new FuncionEntidad();
                /*sala.setId(rs.getInt("id"));
                sala.setNombre(rs.getString("nombre"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setCosto(rs.getInt("costo"));
                salas.add(sala);
                 */
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al leer las salas", e);
        }

        return salas;
    }

    @Override
    public void guardar(FuncionEntidad f, int idSucursal, int idPelicula, int idSala) throws PersistenciaException {
        String query = "INSERT INTO Funciones (costo, horaInicio, horaFin, ID_Pelicula, ID_Sucursal, ID_Sala, estaEliminada, fechaRegistro) "
                + "VALUES (?, ?, ?, ?, ?, ?, false, ?)";

        try (Connection conn = conexionBD.crearConexion(); // Cambiado aquí
                 PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(1, f.getCosto());
            stmt.setTime(2, f.getHoraInicio());
            stmt.setTime(3, f.getHoraFin());
            stmt.setInt(4, idPelicula);
            stmt.setInt(5, idSucursal);
            stmt.setInt(6, idSala);
            stmt.setString(7, f.getFechaHoraRegistro());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar sala: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void eliminar(int idFuncion) throws PersistenciaException {
        String consulta = "DELETE FROM Salas WHERE id = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {

            ps.setInt(1, idFuncion);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la sala", e);
        }
    }

    @Override
    public List<FuncionEntidad> buscarFunciones(Tabla filtro, int IDS) throws PersistenciaException {
        List<FuncionEntidad> funciones = new ArrayList<>();
        String consulta = "SELECT ID, costo, horaInicio, horaFin, ID_Pelicula, ID_Sucursal, ID_Sala, estaEliminada, fechaRegistro FROM Funciones WHERE ID_Sucursal = ?  LIMIT ? OFFSET ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement ps = connection.prepareStatement(consulta)) {
            int limite = filtro.getLimite();
            int pagina = filtro.getPagina() * filtro.getLimite();
            System.out.println("Consulta SQL: " + consulta);
            System.out.println("Límite: " + limite);
            System.out.println("Página (Offset): " + pagina);

            ps.setInt(1, IDS);
            ps.setInt(2, limite);
            ps.setInt(3, pagina);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FuncionEntidad f = new FuncionEntidad();
                    f.setID(rs.getInt("ID"));
                    f.setCosto(rs.getFloat("costo"));
                    f.setHoraInicio(rs.getTime("horaInicio"));
                    f.setHoraFin(rs.getTime("horaFin"));
                    f.setIdPelicula(rs.getInt("ID_Pelicula"));
                    f.setIdSucursal(rs.getInt("ID_Sucursal"));
                    f.setIdSala(rs.getInt("ID_Sala"));
                    f.setEstaEliminado(rs.getBoolean("estaEliminada"));
                    f.setFechaHoraRegistro(rs.getString("fechaRegistro"));
                    
                    funciones.add(f);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            throw new PersistenciaException("Error al buscar las salas", e);
        }

        return funciones;
    }

    @Override
    public IConexionBD getConexionBD() {
        return conexionBD;
    }
}
