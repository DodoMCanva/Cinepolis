package negocio;

import persistencia.PersistenciaException;

public class NegocioException extends Exception {
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
