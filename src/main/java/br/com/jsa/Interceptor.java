package br.com.jsa;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.jsa.model.Usuario;

public class Interceptor implements PhaseListener {

	private static final long serialVersionUID = -773294083918159098L;

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/login.xhtml".equals(nomePagina) || nomePagina.equals("usuarioCadastro.xhtml")) {
			return;
		}

		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");

		if (usuarioLogado != null) {
			try{
				Autorizacao autorizacao = new Autorizacao(usuarioLogado.getPermissao(), nomePagina);
				return;
			}catch (RuntimeException e) {
				System.out.println("ERRO NA EXECUÇÃO");
			}


		}

		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");

		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}