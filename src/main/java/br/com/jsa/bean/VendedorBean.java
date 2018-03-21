package br.com.jsa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Permissao;
import br.com.jsa.model.Telefone;
import br.com.jsa.model.TipoTelefone;
import br.com.jsa.model.Usuario;
import br.com.jsa.model.Vendedor;
import br.com.jsa.service.PermissaoService;
import br.com.jsa.service.TipoTelefoneService;
import br.com.jsa.service.VendedorService;

@Named("vendedorBean")
@SessionScoped
public class VendedorBean implements Serializable {

	private static final long serialVersionUID = -5460821205129034444L;

	@Inject
	private VendedorService vendedorService;
	@Inject
	private TipoTelefoneService tipoTelefoneService;
	@Inject
	private PermissaoService permissaoService;
	@Inject
	private Vendedor vendedor;
	@Inject
	private Usuario usuario;
	@Inject
	private Telefone telefone;
	@Inject
	private Permissao permissao;
	private FacesContext context;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private List<Permissao> permissoes = new ArrayList<Permissao>();;
	private List<TipoTelefone> listaTipoTelefones = new ArrayList<TipoTelefone>();
	private List<Permissao> listaPermissoes = new ArrayList<Permissao>();
	private List<Vendedor> todosVendedores = new ArrayList<Vendedor>();

	public void adicionarTelefone() {
		if (telefone.getTipoTelefone() != null) {
			if (telefones.contains(telefone)) {
				telefones.remove(telefone);
			}
			telefones.add(telefone);
			telefone = new Telefone();
		}
	}

	public void adicionarPermissao() {
		permissoes.add(permissao);
		permissao = new Permissao();

	}

	public void removerTelefoneList(Telefone telefone) {
		telefones.remove(telefone);
	}

	public void removerPermissao(Permissao permissao) {
		permissoes.remove(permissao);
	}

	public void capturarTelefoneList(Telefone telefone) {
		this.telefone = telefone;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public List<TipoTelefone> getListaTipoTelefones() {
		listaTipoTelefones = tipoTelefoneService.buscarTodos();
		return listaTipoTelefones;
	}

	public List<Permissao> getListaPermissoes() {
		listaPermissoes = permissaoService.buscarTodos();
		return listaPermissoes;
	}

	public String salvar() {
		usuario.setPermissao(permissoes);
		vendedor.setUsuario(usuario);
		vendedor.setTelefone(telefones);
		
		vendedorService.salvar(vendedor);
		
		vendedor = new Vendedor();
		telefones = new ArrayList<Telefone>();
		usuario = new Usuario();
		permissoes = new ArrayList<Permissao>();
		
		context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Salvo com sucesso"));
		return "form?faces-redirect=true";
	}

	public List<Vendedor> getTodosVendedores() {
		todosVendedores = vendedorService.buscarTodosVendedores();
		return todosVendedores;
	}

	public String editar(Vendedor vendedor) {
		this.vendedor = vendedor;
		this.telefones = vendedor.getTelefone();
		this.usuario = vendedor.getUsuario();
		this.permissoes = vendedor.getUsuario().getPermissao();
		return "editar?faces-redirect=true";
	}

	public String atualizar() {
		usuario.setPermissao(permissoes);
		vendedor.setUsuario(usuario);
		vendedor.setTelefone(telefones);
		
		vendedorService.atualizar(vendedor);
		
		vendedor = new Vendedor();
		telefones = new ArrayList<Telefone>();
		usuario = new Usuario();
		permissoes = new ArrayList<Permissao>();
		return "form?faces-redirect=true";
	}
	
	public void remover(Vendedor vendedor) {
		vendedorService.remover(vendedor);
	}

	public String detalheVendedor(Vendedor vendedor) {
		vendedor = vendedorService.detalheVendedor(vendedor.getIdPessoa());
		return "detalhe-cliente?faces-redirect=true";
	}

}
