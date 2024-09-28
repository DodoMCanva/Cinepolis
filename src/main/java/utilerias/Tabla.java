package utilerias;


public class Tabla {
    private int limite;
    private int pagina;
    private String textoBusqueda;

    public Tabla(int limite, int pagina, String textoBusqueda) {
        this.limite = limite;
        this.pagina = pagina;
        this.textoBusqueda = textoBusqueda;
    }

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
