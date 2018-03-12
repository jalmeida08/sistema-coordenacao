package br.com.jsa.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Aluno;
import br.com.jsa.service.AlunoService;

@Named
@SessionScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = 8738805493610514548L;
	
	@Inject
	private AlunoService alunoService;
	@Inject
	private Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}

	public String salvar() {
		alunoService.salvar(aluno);
		return "form?faces-redirect=true";
	}
}
