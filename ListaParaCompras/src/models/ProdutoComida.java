package models;

public class ProdutoComida extends Produto{
	
	public ProdutoComida(String nome, String quantidade, String categoria) {
		super(nome, quantidade, categoria);
	}
	
	public String categ(){
		
		return "1";
	}
}
