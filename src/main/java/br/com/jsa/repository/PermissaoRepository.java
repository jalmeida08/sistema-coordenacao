package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.jsa.model.Permissao;

public class PermissaoRepository {

	@Inject
	private EntityManager manager;

	public Permissao getPermisao(Long idPermisao) {

		try {
			return manager.createQuery("select p from Permissao p where p.idPermissao = :id", Permissao.class)
					.setParameter("id", idPermisao).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Permissao> buscarTodos() {
		return manager.createQuery("select p from br.com.jsa.model.Permissao p", Permissao.class).getResultList();
	}
}
