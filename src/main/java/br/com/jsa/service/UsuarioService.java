package br.com.jsa.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.TransactionScoped;

import br.com.jsa.model.Usuario;
import br.com.jsa.repository.UsuarioRepository;

@Stateless
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void salvar() {

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario logar(Usuario usuario) {
		return usuarioRepository.logar(usuario);
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public boolean checarSenhaAleatoria(Usuario usuario) {
		if (usuario.isSenhaAleatoria()) {
			return true;
		}
		return false;
	}

	public boolean checarSenha(String senha, String confirmeSenha) {
		if(senha.equals(confirmeSenha) && senha.length() >= 8){
			return true;
		}
		return false;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizarSenha(Usuario usuario, String novaSenha) {
		usuarioRepository.atualizarSenha(usuario, novaSenha);
		
	}
}
