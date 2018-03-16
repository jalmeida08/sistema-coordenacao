package br.com.jsa.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Permissao;
import br.com.jsa.model.Professor;
import br.com.jsa.model.Telefone;
import br.com.jsa.model.TipoTelefone;
import br.com.jsa.model.Usuario;
import br.com.jsa.service.PermissaoService;
import br.com.jsa.service.ProfessorService;
import br.com.jsa.service.TipoTelefoneService;

@Named("professorBean")
@SessionScoped
public class ProfessorBean implements Serializable{

	private static final long serialVersionUID = 679733076139929958L;
	
	@Inject
	private ProfessorService professorService;
	@Inject
	private TipoTelefoneService tipoTelefoneService;
	@Inject
	private PermissaoService permissaoService;
	@Inject
	private Professor professor;
	@Inject
	private Usuario Usuario;
	@Inject
	private Permissao permissao;
	@Inject
	private Telefone telefone;
	@Inject
	private TipoTelefone tipoTelefone;
	private List<Telefone> telefones;
	private List<Permissao> permissoes;
	private List<Permissao> listaPermissao;
	private List<TipoTelefone> listaTipoTelefone;
	
	public Professor getProfessor() {
		return professor;
	}

	public void capturarTelefoneList(Telefone telefone){
		this.telefone = telefone;
	}
	
	public void removerTelefoneList(Telefone telefone){
		telefones.remove(telefone);
	}
	
	public TipoTelefoneService getTipoTelefoneService() {
		return tipoTelefoneService;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public List<Permissao> getListaPermissao() {
		listaPermissao = permissaoService.buscarTodos();
		return listaPermissao;
	}

	public List<TipoTelefone> getListaTipoTelefone() {
		listaTipoTelefone = tipoTelefoneService.buscarTodos();
		return listaTipoTelefone;
	}

	public void salvar(){
		professorService.salvar(professor);
	}
	
}
