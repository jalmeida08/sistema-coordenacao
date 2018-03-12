package br.com.jsa.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jsa.model.Aluno;
import br.com.jsa.repository.AlunoRepository;

@Stateless
public class AlunoService {

	@Inject
	private AlunoRepository alunoRepository;
	
	public void salvar(Aluno aluno) {
		alunoRepository.salvarAluno(aluno);
	}

	
}
