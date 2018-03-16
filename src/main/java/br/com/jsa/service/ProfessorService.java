package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.model.Professor;
import br.com.jsa.repository.ProfessorRepository;

@Stateless
public class ProfessorService {

	
	@Inject
	private ProfessorRepository professorRepository;
	
	public Professor getProfessor(Long idProfessor){
		return professorRepository.getProfessor(idProfessor);
	}
	
	public List<Professor> buscarTodosProfessores(){
		return professorRepository.buscarTodosProfessores();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Professor professor){
		professorRepository.salvar(professor);
	}
}
