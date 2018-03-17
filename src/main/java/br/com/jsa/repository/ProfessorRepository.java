package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsa.model.Professor;
import br.com.jsa.model.Telefone;
import br.com.jsa.model.Usuario;

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
		Usuario usuario = professor.getUsuario();
		System.out.println("TAMANHO DO PROFESSOR: "+professor.getTelefone().size());
		List<Telefone> list = professor.getTelefone();
		System.out.println("TAMANHO DO list I : "+list.size());
		if(list.size() >= 1) {
			for (Telefone telefone : list) {
				telefone.setPessoa(professor);
			}
		}
		professor.setTelefone(list);
		usuario.setPessoa(professor);

		System.out.println("TAMANHO DO PROFESSOR II : "+professor.getTelefone().size());
		manager.persist(professor);
	}
}
