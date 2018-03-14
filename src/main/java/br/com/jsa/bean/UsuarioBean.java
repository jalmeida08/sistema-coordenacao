package br.com.jsa.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Usuario;
import br.com.jsa.service.UsuarioService;

@Named(value="usuarioBean")
@SessionScoped
public class UsuarioBean {

	@Inject
	private UsuarioService usuarioService;
	@Inject
	private Usuario usuario;
	private FacesContext context = FacesContext.getCurrentInstance();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void salvar() {
		
	}
	
	public String login() {
		context = FacesContext.getCurrentInstance();
		Usuario usuario = usuarioService.logar(this.usuario);
		if (usuario == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Login ou senha inválido"));
			return null;
		}
		context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
		
		return "despesa?faces-redirect=true";
	}
	
	
}
