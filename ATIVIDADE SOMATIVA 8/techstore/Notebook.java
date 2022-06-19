package techstore;


public class Notebook extends Tech{
	private static final long serialVersionUID = 1L;
    private String processador;
    private int memoria;
    private int disco;
    private float tela;
    
    
    public boolean ligar() {
        return true;
    }
    public Notebook(String marca, String modelo, String processador, int preco) {
		super(marca, modelo, preco);
		this.produto = "Notebook";        
	}
    public void setProcessador(String processador){
        this.processador = processador;
    }
    public String getProcessador(){
        return processador;
    }

}
