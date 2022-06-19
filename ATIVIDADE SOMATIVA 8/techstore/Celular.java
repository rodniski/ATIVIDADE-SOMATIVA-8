package techstore;


public class Celular extends Tech{
	private static final long serialVersionUID = 1L;
    private String processador;
    private int camera;
    private int disco;
    private float tela;
    
    
    public boolean ligar() {
        return true;
    }
    public Celular(String marca, String modelo, int camera ,int preco) {
		super(marca, modelo, preco);
		this.produto = "Celular";        
	}
    public void setCamera(int camera){
        this.camera = camera;
    }
    public int getCamera(){
        return camera;
    }   
}
