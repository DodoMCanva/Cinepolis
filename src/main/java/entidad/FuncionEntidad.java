package entidad;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class FuncionEntidad {

    private int ID;
    private float costo;
    private Time horaInicio;
    private Time horaFin;
    private int idPelicula;
    private int idSucursal;
    private int idSala;
    private boolean estaEliminado;
    private String fechaHoraRegistro;

    public FuncionEntidad(int ID, float costo, Time horaInicio, Time horaFin, int idPelicula, int idSucursal, int idSala, boolean estaEliminado, String fechaHoraRegistro) {
        this.ID = ID;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idPelicula = idPelicula;
        this.idSucursal = idSucursal;
        this.idSala = idSala;
        this.estaEliminado = estaEliminado;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public FuncionEntidad() {
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public String getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(String fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    

}
