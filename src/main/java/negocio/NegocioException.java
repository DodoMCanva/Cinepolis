package negocio;

public class NegocioException extends Exception {
    public NegocioException(String mensaje,Throwable causa){
    super (mensaje,causa);
    }
     
    public NegocioException(String mensaje) {
        super(mensaje);
    }
}