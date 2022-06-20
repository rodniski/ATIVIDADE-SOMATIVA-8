package techstore;


public class Relogio extends Tech{
	private static final long serialVersionUID = 1L;
    private String pulseira;
    
    public Relogio(String marca, String modelo, String pulseira, int preco) {
		super(marca, modelo, preco);
		this.produto = "Relogio";    
        this.pulseira = pulseira;    
	}
    public void setPulseira(String pulseira){
        this.pulseira = pulseira;
    }
    public String getPulseira(){
        return pulseira;
    }
    @Override
    public String toString() {
		String retorno = "";
		retorno += "Produto: "  + this.produto  + "\n";
		retorno += "Marca: "  +this.marca  + "\n";
		retorno += "Modelo: " +this.modelo + "\n";
        retorno += "Pulseira: "  +this.pulseira  + "\n";
        retorno += "Preco: R$"  +this.preco  + ",00\n";
				return retorno;
	}
}
