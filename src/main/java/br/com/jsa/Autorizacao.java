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
			return autorizacaoAdministrador(pagina, permissao);
		}
		if (permissao.getDescricao().equals("vendedor")) {
			return autorizacaoVendedor(pagina, permissao);
		}
		if (permissao.getDescricao().equals("aluno")) {
			return autorizacaoAluno(pagina, permissao);
		}
		if (permissao.getDescricao().equals("coordenador")) {
			return autorizacaoCoordenador(pagina, permissao);
		}
		if (permissao.getDescricao().equals("professor")) {
			return autorizacaoProfessor(pagina, permissao);
		}
		return false;

	}

	public boolean autorizacaoAdministrador(String pagina, Permissao permissao) {
		if (!pagina.startsWith("/")) {
			return false;
		}
		return true;
	}

	public boolean autorizacaoProfessor(String pagina, Permissao permissao) {
		if ((!pagina.startsWith("/professor")) || pagina.startsWith("/usuarios/professor")) {
			return false;
		}
		return true;
	}

	public boolean autorizacaoAluno(String pagina, Permissao permissao) {
		if ((!pagina.startsWith("/aluno")) || pagina.startsWith("/usuarios/aluno")) {
			return false;
		}
		return true;
	}

	public boolean autorizacaoCoordenador(String pagina, Permissao permissao) {
		if (!pagina.startsWith("/coordenador/")) {
			return false;
		}
		return true;
	}

	public boolean autorizacaoVendedor(String pagina, Permissao permissao) {
		if ((!pagina.startsWith("/vendedor/")) || pagina.startsWith("/usuario/vendedor")) {
			return false;
		}
		return true;
	}
}
