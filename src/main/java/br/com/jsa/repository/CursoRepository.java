package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Curso;

public class CursoRepository {
	
	@Inject
	private EntityManager manager;

	public Curso getCurso(Long idCurso) {
		return manager.find(Curso.class, idCurso);
	}
	
	public List<Curso> buscarTodosCursos(){
		return manager.createQuery("select c from Curso c", Curso.class).getResultList();
	}
	
	public void salvar(Curso curso) {
		manager.persist(curso);
	}
	
	public void remover(Curso curso) {
		manager.remove(curso);
	}
	
	
}
