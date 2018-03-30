package br.com.jsa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Curso;
import br.com.jsa.service.CursoService;

@Named("cursoBean")
@SessionScoped
public class CursoBean implements Serializable{

	private static final long serialVersionUID = -9141570649364106237L;
	
	@Inject
	private CursoService cursoService;
	@Inject
	private Curso curso;
	private List<Curso> cursos= new ArrayList<Curso>();

	public Curso getCurso() {
		return curso;
	}
	
	public List<Curso> getCursos() {
		cursos = cursoService.buscarTodosCursos();
		return cursos;
	}

	public String salvar() {
		cursoService.salvar(curso);
		curso = new Curso();
		return "cadastrar-curso?faces-redirect=true";
	}
}
