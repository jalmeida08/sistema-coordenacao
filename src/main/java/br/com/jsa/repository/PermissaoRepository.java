package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Permissao;

public class PermissaoRepository {

	@Inject
	private EntityManager manager;

	public Permissao getPermisao(Long idPermissao) {
		return manager.find(Permissao.class, idPermissao);
	}

	public List<Permissao> buscarTodos() {
		return manager.createQuery("select p from br.com.jsa.model.Permissao p", Permissao.class).getResultList();
	}
}
