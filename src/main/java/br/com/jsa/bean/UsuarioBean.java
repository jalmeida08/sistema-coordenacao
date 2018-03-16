package br.com.jsa.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Usuario;
import br.com.jsa.service.UsuarioService;

@Named(value="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = -813274541784078383L;
	
	@Inject
	private UsuarioService usuarioService;
	@Inject
	private Usuario usuario;
	private FacesContext context;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void limpar() {
		usuario = new Usuario();
	}
	
	public void salvar() {
		
	}
	
	public String login() {
		context = FacesContext.getCurrentInstance();
		Usuario usuario = usuarioService.logar(this.usuario);
		if (usuario == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "E-mail ou senha inválido"));
			return null;
		}
		context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
		
		return "home?faces-redirect=true";
	}
	
	
}
