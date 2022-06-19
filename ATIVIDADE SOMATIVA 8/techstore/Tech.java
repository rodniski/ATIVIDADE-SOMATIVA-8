package techstore;

import java.io.Serializable;

public abstract class Tech implements Serializable {
    private static final long serialVersionUID = 1L;
	public   String marca;
	public   String modelo;
	public   int preco;
	protected String produto;

    public Tech(String marca, String modelo, int preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}
	public String toString() {
		String retorno = "";
		retorno += "Produto: "  + this.produto  + "\n";
		retorno += "Marca: "  +this.marca  + "\n";
		retorno += "Modelo: " +this.modelo + "\n";
		retorno += "Preco: R$"  +this.preco  + ",00\n";
				return retorno;
	}	
}