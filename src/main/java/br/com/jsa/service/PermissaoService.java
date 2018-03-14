package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jsa.model.Permissao;
import br.com.jsa.repository.PermissaoRepository;

@Stateless
public class PermissaoService {
	
	@Inject
	private PermissaoRepository permissaoRepository;
	
	public Permissao getPermisao(Long idPermisao) {
		return permissaoRepository.getPermisao(idPermisao);
	}

	public List<Permissao> buscarTodos() {
		return permissaoRepository.buscarTodos();
	}

}
