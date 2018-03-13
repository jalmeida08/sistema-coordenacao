package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Aluno;
import br.com.jsa.model.Telefone;

public class AlunoRepository {

	@Inject
	private EntityManager manager;

	public Aluno getAluno(Long idAluno) {
		return manager.find(Aluno.class, idAluno);
	}

	public void salvarAluno(Aluno aluno) {
		List<Telefone> list = aluno.getTelefone();
		if (list != null) {
			for (Telefone telefone : list) {
				telefone.setPessoa(aluno);
			}
		}
		aluno.setTelefone(list);
		manager.persist(aluno);
	}

	public List<Aluno> buscarTodosAlunos() {
		return manager.createQuery("select a from Aluno a ", Aluno.class).getResultList();
	}

	public void atualizar(Aluno aluno) {
		manager.merge(aluno);
	}

	public void remover(Aluno aluno) {
		manager.remove(aluno);
	}

}
