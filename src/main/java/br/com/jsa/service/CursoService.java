package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.model.Curso;
import br.com.jsa.repository.CursoRepository;

@Stateless
public class CursoService {

	@Inject
	private CursoRepository cursoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Curso curso) {
		cursoRepository.salvar(curso);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Curso curso) {
		cursoRepository.remover(curso);
	}

	public List<Curso> buscarTodosCursos() {
		return cursoRepository.buscarTodosCursos();
	}
}
