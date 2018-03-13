package br.com.jsa.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.model.Aluno;
import br.com.jsa.repository.AlunoRepository;

@Stateless
public class AlunoService {

	@Inject
	private AlunoRepository alunoRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarAluno(Aluno aluno) {
		alunoRepository.salvarAluno(aluno);
	}

	
}
