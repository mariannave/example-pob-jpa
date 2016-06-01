import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Teste {

	protected static EntityManager manager;

	public Teste(){
		Query query;
		Produto prod1;

		//Estanciação do Manager
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("loja");
		manager = factory.createEntityManager();

		//Persistindo os objetos no banco
		manager.getTransaction().begin();
		prod1 = new Produto("Arroz",2.40);
		manager.persist(prod1);
		prod1 = new Produto("Feijão",5.00);
		manager.persist(prod1);
		prod1 = new Produto("Macarrão",1.99);
		manager.persist(prod1);
		prod1 = new Produto("Biscoito",1.50);
		manager.persist(prod1);		
		prod1 = new Produto("Açucar",2.59);
		manager.persist(prod1);
		prod1 = new Produto("Banana",3.40);
		manager.persist(prod1);
		prod1 = new Produto("Maçã",5.60);
		manager.persist(prod1);
		prod1 = new Produto("Manteiga",4.70);
		manager.persist(prod1);
		prod1 = new Produto("Queijo",13.00);
		manager.persist(prod1);
		prod1 = new Produto("Ovos",12.00);
		manager.persist(prod1);
		prod1 = new Produto("Leite",2.80);
		manager.persist(prod1);
		manager.getTransaction().commit();

		//Mudando o preço do produto de ID 5 - Dobrando o preço
		manager.getTransaction().begin();
		prod1 = manager.find(Produto.class,5);
		double precoAtual = prod1.getPreco();
		double precoAtualizado = precoAtual * 2;
		prod1.setPreco(precoAtualizado);
		manager.merge(prod1);
		manager.getTransaction().commit();

		//Apagando o produto de ID 10
		manager.getTransaction().begin();
		prod1 = manager.find(Produto.class,10);
		manager.remove(prod1);
		manager.getTransaction().commit();

//		//Listando todos os produtos
		System.out.println("Lista de produtos: ");
		query = manager.createQuery("Select p from Produto p");
		List<Produto> produtos = (List<Produto>)query.getResultList();
		for(Produto p: produtos){
			System.out.println(p);
		}

		//Aumentando o preço de todos os produtos em 10%
		query = manager.createQuery("Select p from Produto p");
		List<Produto> produtos = (List<Produto>)query.getResultList();
		for(Produto p: produtos){
			double novoPreco = p.getPreco() * 1.10;
			p.setPreco(novoPreco);
			 manager.getTransaction().begin();
	         manager.merge(p);
	         manager.getTransaction().commit();		
	     }
		
		manager.close();
	}
	
	public static void main(String args[]) {
		new Teste();
	}

}
