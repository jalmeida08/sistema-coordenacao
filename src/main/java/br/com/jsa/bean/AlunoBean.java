package br.com.jsa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Aluno;
import br.com.jsa.model.Telefone;
import br.com.jsa.model.TipoTelefone;
import br.com.jsa.service.AlunoService;
import br.com.jsa.service.TipoTelefoneService;

@Named
@SessionScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 8738805493610514548L;

	@Inject
	private AlunoService alunoService;
	@Inject
	private TipoTelefoneService tipoTelefoneService;
	@Inject
	private Aluno aluno;
	@Inject
	private Telefone telefone;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private List<TipoTelefone> listaTipoTelefones;

	public Aluno getAluno() {
		return aluno;
	}

	public void adicionarTelefone() {
		if (telefone.getTipoTelefone() != null) {
			if (telefones.contains(telefone)) {
				telefones.remove(telefone);
				telefones.add(telefone);
			}
			telefones.add(telefone);
			telefone = new Telefone();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Escolha um tipo de telefone"));
		}
	}

	public void removerTelefoneList(Telefone telefone) {
		telefones.remove(telefone);
	}

	public void capturarTelefoneList(Telefone telefone) {
		this.telefone = telefone;
		// telefones.remove(telefone);
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<TipoTelefone> getListaTipoTelefones() {
		listaTipoTelefones = tipoTelefoneService.buscarTodos();
		return listaTipoTelefones;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String salvar() {
		aluno.setTelefone(telefones);
		alunoService.salvarAluno(aluno);
		aluno = new Aluno();
		telefones = new ArrayList<Telefone>();
		return "form?faces-redirect=true";
	}
}
