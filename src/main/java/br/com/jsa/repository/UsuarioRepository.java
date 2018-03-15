package br.com.jsa.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.jsa.model.Usuario;

public class UsuarioRepository {

	@Inject
	private EntityManager manager;

	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario logar(Usuario usuario) {
		try{
			return manager.createQuery("select u from br.com.jsa.model.Usuario u where u.email = :email and u.senha = :senha", Usuario.class)
				.setParameter("email", usuario.getEmail())
				.setParameter("senha", usuario.getSenha())
				.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
