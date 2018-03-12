package br.com.jsa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jsa.model.Aluno;

public class AlunoRepository {
	
	private EntityManager manager;
	
	public void salvarAluno(Aluno aluno) {
		manager.persist(aluno);
	}
	
	public Aluno getAluno(Long idAluno) {
		return manager.find(Aluno.class, idAluno);
	}
	
	public List<Aluno> buscarTodosAlunos(){
		return manager.createQuery("select a from Aluno a ", Aluno.class).getResultList();
	}
	
	public void atualizar(Aluno aluno) {
		manager.merge(aluno);
	}
	
	public void remover(Aluno aluno) {
		manager.remove(aluno);
	}

}
