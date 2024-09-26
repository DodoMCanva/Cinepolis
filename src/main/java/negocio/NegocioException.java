package negocio;

import persistencia.PersistenciaException;

public class NegocioException extends Exception {

    public NegocioException(String message) {
        super(message);
    }

    NegocioException(String mesaje, PersistenciaException e) {
        super(mesaje, e);
    }


}
