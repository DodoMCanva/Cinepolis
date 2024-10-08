package entidad;

import java.util.Date;
import java.util.Objects;

public class SucursalEntidad {
    private int ID;
  private String nombre;
    private String estado;
    private String ciudad;
    private String calle;
    private String codigoPostal;
    private boolean estaEliminado;
    private java.util.Date fechaHoraRegistro;
    
    public SucursalEntidad(){
        
    }

    public SucursalEntidad(int ID, String nombre, String estado, String ciudad, String calle, String codigoPostal, boolean estaEliminado, Date fechaHoraRegistro) {
        this.ID=ID;
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.estaEliminado = estaEliminado;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SucursalEntidad other = (SucursalEntidad) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

  
    
}
