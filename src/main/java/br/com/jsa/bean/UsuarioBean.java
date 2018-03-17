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
	private String novaSenha;
	private String confirmeSenha;
	private FacesContext context;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}

	public void limpar() {
		usuario = new Usuario();
	}
	
	
	public String login() {
		context = FacesContext.getCurrentInstance();
		Usuario usuario = usuarioService.logar(this.usuario);
		if (usuario == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "E-mail ou senha inv�lido"));
			return null;
		}
		context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
		if(usuarioService.checarSenhaAleatoria(usuario)){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta!", "Bem vindo! por favor, crie uma nova senha"));
			return "/usuario/trocar-senha?faces-redirect=true";
		}
		
		return "/home?faces-redirect=true";
	}

	public String atualizarSenha() {
		context = FacesContext.getCurrentInstance();
		usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		if (usuarioService.checarSenha(novaSenha, confirmeSenha)) {
			usuarioService.atualizarSenha(usuario, novaSenha);
			usuario.setSenha(novaSenha);
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			usuario = new Usuario();
			novaSenha = null;
			confirmeSenha = null;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Senha atualizada com sucesso."));
			return "/home?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! ",
				"Verifique a senha, deve conter no mínimo 8 digitos."));
		return "trocar-senha";

	}	
	
}
