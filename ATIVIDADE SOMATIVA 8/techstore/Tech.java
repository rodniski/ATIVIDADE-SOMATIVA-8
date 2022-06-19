package techstore;

import java.io.Serializable;

public abstract class Tech implements Serializable {
    private static final long serialVersionUID = 1L;
	private   String marca;
	private   String modelo;
	private   float preco;

    public Tech(String nome, int idade, String dono) {
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}
	public String toString() {
		String retorno = "";
		retorno += "Marca: "  +this.marca  + "\n";
		retorno += "Modelo: " +this.modelo + "\n";
		retorno += "Preco: "  +this.preco  + "\n";
		return retorno;
	}	
}