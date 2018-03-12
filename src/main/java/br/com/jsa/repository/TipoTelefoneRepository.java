package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.TipoTelefone;

public class TipoTelefoneRepository {

	@Inject
	private EntityManager manager;
	
	public TipoTelefone getTipoTelefone(Integer id) {
		return manager.find(TipoTelefone.class, id);
	}
	
	public List<TipoTelefone> buscarTodos() {
		return manager.createQuery("select t from br.com.jsa.model.TipoTelefone t", TipoTelefone.class).getResultList();
	}

}
