package br.com.jsa.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Aluno;
import br.com.jsa.model.Telefone;
import br.com.jsa.model.TipoTelefone;
import br.com.jsa.service.AlunoService;
import br.com.jsa.service.TipoTelefoneService;

@Named
@SessionScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = 8738805493610514548L;
	
	@Inject
	private AlunoService alunoService;
	@Inject
	private TipoTelefoneService tipoTelefoneService;
	@Inject
	private Aluno aluno;
	private Telefone telefone;
	private List<TipoTelefone> listaTipoTelefones;

	public Aluno getAluno() {
		return aluno;
	}

	public List<TipoTelefone> getListaTipoTelefones() {
		listaTipoTelefones = tipoTelefoneService.buscarTodos();
		return listaTipoTelefones;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public String salvar() {
		alunoService.salvar(aluno);
		return "form?faces-redirect=true";
	}
}
