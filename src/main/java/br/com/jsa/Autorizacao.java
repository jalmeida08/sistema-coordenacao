package br.com.jsa;

import java.util.ArrayList;
import java.util.List;

import br.com.jsa.model.Permissao;

public class Autorizacao {

	private List<Permissao> permissao = new ArrayList<Permissao>();
	private String pagina;

	public Autorizacao(List<Permissao> permissoes, String pagina) {
		this.permissao = permissoes;
		this.pagina = pagina;
		percorrerLista();
	}

	public void percorrerLista() {
		List<Boolean> checarPermissao = new ArrayList<Boolean>();
		for (Permissao p : permissao) {
			checarPermissao.add(chamarAutorizador(pagina, p));
		}
		if (!checarPermissao.contains(true)) {
			throw new RuntimeException();
		}

	}

	public boolean chamarAutorizador(String pagina, Permissao permissao) {
		if (permissao.getDescricao().equals("administrador")) {
			return autorizacaoAdministrador(pagina);
		}
		if (permissao.getDescricao().equals("vendedor")) {
			return autorizacaoVendedor(pagina);
		}
		if (permissao.getDescricao().equals("aluno")) {
			return autorizacaoAluno(pagina);
		}
		if (permissao.getDescricao().equals("coordenador")) {
			return autorizacaoCoordenador(pagina);
		}
		if (permissao.getDescricao().equals("professor")) {
			return autorizacaoProfessor(pagina);
		}
		return false;

	}

	public boolean autorizacaoAdministrador(String pagina) {
		if (pagina.startsWith("/")) {
			return true;
		}
		return false;
	}

	public boolean autorizacaoProfessor(String pagina) {
		if (pagina.startsWith("/professor") || pagina.startsWith("/usuario/")) {
			return true;
		}
		return false;
	}

	public boolean autorizacaoAluno(String pagina) {
		if (pagina.startsWith("/aluno") || pagina.startsWith("/usuario/")) {
			return true;
		}
		return false;
	}

	public boolean autorizacaoCoordenador(String pagina) {
		if (pagina.startsWith("/coordenador") || pagina.startsWith("/usuario")) {
			return true;
		}
		return false;
	}

	public boolean autorizacaoVendedor(String pagina) {
		if (pagina.startsWith("/vendedor/") || pagina.startsWith("/usuario/")) {
			return true;
		}
		return false;
	}
}
