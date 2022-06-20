package techstore;

public class Notebook extends Tech {
    private static final long serialVersionUID = 1L;
    private String processador;

    public Notebook(String marca, String modelo, String processador, int preco) {
        super(marca, modelo, preco);
        this.produto = "Notebook";
        this.processador = processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getProcessador() {
        return processador;
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "Produto: " + this.produto + "\n";
        retorno += "Marca: " + this.marca + "\n";
        retorno += "Modelo: " + this.modelo + "\n";
        retorno += "Processador: " + this.processador + "\n";
        retorno += "Preco: R$" + this.preco + ",00\n";
        return retorno;
    }
}
