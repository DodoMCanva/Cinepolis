package persistencia;

import entidad.FuncionEntidad;
import entidad.FuncionEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionDAO {

    private Connection connection;

    public FuncionDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarFuncion(FuncionEntidad funcion) throws SQLException {
        String query = "INSERT INTO Funciones (costo, horaInicio, horaFin, ID_Pelicula, ID_Sala, estaEliminada) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setFloat(1, funcion.getCosto());
            ps.setTime(2, funcion.getHoraInicio());
            ps.setTime(3, funcion.getHoraFin());
            ps.setInt(4, funcion.getIdPelicula());
            ps.setInt(5, funcion.getIdSala());
            ps.setBoolean(6, funcion.isEstaEliminada());
            ps.executeUpdate();
        }
    }

    public List<FuncionEntidad> obtenerFunciones() throws SQLException {
        List<FuncionEntidad> funciones = new ArrayList<>();
        String query = "SELECT * FROM Funciones WHERE estaEliminada = false";
        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FuncionEntidad funcion = new FuncionEntidad();
                funcion.setId(rs.getInt("ID"));
                funcion.setCosto(rs.getFloat("costo"));
                funcion.setHoraInicio(rs.getTime("horaInicio"));
                funcion.setHoraFin(rs.getTime("horaFin"));
                funcion.setIdPelicula(rs.getInt("ID_Pelicula"));
                funcion.setIdSala(rs.getInt("ID_Sala"));
                funcion.setEstaEliminada(rs.getBoolean("estaEliminada"));
                funcion.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
                funciones.add(funcion);
            }
        }
        return funciones;
    }
    
    public void eliminarFuncion(int id) throws SQLException {
        String query = "UPDATE Funciones SET estaEliminada = true WHERE ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
