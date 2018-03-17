package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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

	public Permissao buscarPermissaoProfessor() {
		try {
			return manager.createQuery("select p from br.com.jsa.model.Permissao p where p.descricao = :professor", Permissao.class)
					.setParameter("professor", "professor").getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
