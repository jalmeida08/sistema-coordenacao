package br.com.jsa.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.model.Usuario;
import br.com.jsa.repository.UsuarioRepository;

@Stateless
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void salvar() {
		
	}

	public Usuario logar(Usuario usuario) {
		return usuarioRepository.logar(usuario);
	}
}
