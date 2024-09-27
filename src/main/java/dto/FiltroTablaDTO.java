package dto;

/**
 *
 * @author cesar
 */
public class FiltroTablaDTO {

    private int limite;
    private int pagina;
    private String textoBusqueda; // Texto para buscar por nombre

    public FiltroTablaDTO(int limite, int pagina, String textoBusqueda) {
        this.limite = limite;
        this.pagina = pagina;
        this.textoBusqueda = textoBusqueda;
    }

    // Getters y Setters
    public int getLimite() {
        return limite;
    }

    public int getPagina() {
        return pagina;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

}
