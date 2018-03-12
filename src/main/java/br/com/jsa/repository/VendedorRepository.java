package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Vendedor;

public class VendedorRepository {

	@Inject 
	private EntityManager manager;
	
	public void salvar(Vendedor vendedor) {
		manager.persist(vendedor);
	}
	
	public Vendedor getVendedor(Long idVendedor) {
		return manager.find(Vendedor.class, idVendedor);
	}
	
	public List<Vendedor> buscarTodosVendedores(){
		return manager.createQuery("select v from Vendedor v", Vendedor.class).getResultList();
	}
	
	public void atualizar(Vendedor vendedor) {
		manager.merge(vendedor);
	}
	
	public void remover(Vendedor vendedor) {
		manager.remove(vendedor);
	}

}