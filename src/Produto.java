

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;

	//Construtor vazio
	public Produto(){};

	public Produto(String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	}

	public int getId(){
		return this.id;
	}

	public String getNome(){
		return this.nome;
	}

	public double getPreco(){
		return this.preco;
	}

	public void setPreco(double preco){
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "ID: "+ this.id + "- Nome: " + this.nome + "- Preço:" + this.preco ;
	}
}



