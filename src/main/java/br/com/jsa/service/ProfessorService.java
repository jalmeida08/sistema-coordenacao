package br.com.jsa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.EnviarEmail;
import br.com.jsa.GerarSenhas;
import br.com.jsa.model.Permissao;
import br.com.jsa.model.Professor;
import br.com.jsa.repository.PermissaoRepository;
import br.com.jsa.repository.ProfessorRepository;

@Stateless
public class ProfessorService {

	
	@Inject
	private ProfessorRepository professorRepository;
	@Inject
	private PermissaoRepository permissaoRepository;
	
	public Professor getProfessor(Long idProfessor){
		return professorRepository.getProfessor(idProfessor);
	}
	
	public List<Professor> buscarTodosProfessores(){
		return professorRepository.buscarTodosProfessores();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Professor professor){
		Permissao permissao = permissaoRepository.buscarPermissaoProfessor();
		List<Permissao> permissoes = new ArrayList<Permissao>();
		permissoes.add(permissao);
		String senhaAleatoria = GerarSenhas.getRandomPassword();
		EnviarEmail email = new EnviarEmail(professor.getUsuario().getEmail(), senhaAleatoria);

		if(email.enviarEmailDePrimeiroAcesso() == false) {
			throw new RuntimeException("Erro ao enviar o email");
		}
		
		professor.getUsuario().setSenhaAleatoria(true);
		professor.getUsuario().setSenha(senhaAleatoria);
		professor.getUsuario().setPermissao(permissoes);
		
		professorRepository.salvar(professor);
	}
}
