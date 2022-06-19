package techstore;


public class Relogio extends Tech{
	private static final long serialVersionUID = 1L;
    private String pulseira;
    
    
    public boolean ligar() {
        return true;
    }
    public Relogio(String marca, String modelo, float preco) {
		super(marca, modelo, preco);
		this.produto = "Relogio";        
	}
    public void setPulseira(String pulseira){
        this.pulseira = pulseira;
    }
    public String getPulseira(){
        return pulseira;
    }
}
