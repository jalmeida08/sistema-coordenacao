package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Aluno;
import br.com.jsa.model.Vendedor;

public class AlunoRepository {
	
	@Inject
	private EntityManager manager;
	
	public void salvarAluno(Aluno aluno) {
		Long a = Long.valueOf(3);
		Vendedor find = manager.find(Vendedor.class,a);
		aluno.setVendedor(find);
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
