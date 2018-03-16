package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Professor;

public class ProfessorRepository {

	@Inject
	private EntityManager manager;

	public Professor getProfessor(Long idProfessor){
		return manager.find(Professor.class, idProfessor);
	}
	
	public List<Professor> buscarTodosProfessores(){
		return manager.createQuery("select p from Professor p order by p.nome asc", Professor.class).getResultList();
	}
	
	public void salvar(Professor professor){
		manager.persist(professor);
	}
}
