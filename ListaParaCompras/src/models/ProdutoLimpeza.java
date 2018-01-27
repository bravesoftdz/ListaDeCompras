package models;

public class ProdutoLimpeza extends Produto{
	
	public ProdutoLimpeza(String nome, String quantidade, String categoria) {
		super(nome, quantidade, categoria);
	}

	public String categ(){
		
		return "3";
	}

}
