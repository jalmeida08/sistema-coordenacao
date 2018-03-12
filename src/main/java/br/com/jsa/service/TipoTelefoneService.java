package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jsa.model.TipoTelefone;
import br.com.jsa.repository.TipoTelefoneRepository;

@Stateless
public class TipoTelefoneService {

	@Inject
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	public List<TipoTelefone>buscarTodos() {
		return tipoTelefoneRepository.buscarTodos();
	}
	
	public TipoTelefone getTipoTelefone(Integer id) {
		return tipoTelefoneRepository.getTipoTelefone(id);
	}
}
