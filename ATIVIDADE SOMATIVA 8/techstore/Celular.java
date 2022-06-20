package techstore;

public class Celular extends Tech {
    private static final long serialVersionUID = 1L;
    private int camera;

    public Celular(String marca, String modelo, int camera, int preco) {
        super(marca, modelo, preco);
        this.produto = "Celular";
        this.camera = camera;
    }
    
    @Override   
    public String toString() {
        String retorno = "";
        retorno += "Produto: " + this.produto + "\n";
        retorno += "Marca: " + this.marca + "\n";
        retorno += "Modelo: " + this.modelo + "\n";
        retorno += "Camera: " + this.camera + "MP\n";
        retorno += "Preco: R$" + this.preco + ",00\n";
        return retorno;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getCamera() {
        return camera;
    }

}
