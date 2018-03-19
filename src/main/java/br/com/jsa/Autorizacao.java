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
		for (Permissao p : permissao) {
			System.out.println("A PERMISSAO È: " + p.getDescricao());
			chamarAutorizador(pagina, p);
		}
	}

	public void chamarAutorizador(String pagina, Permissao permissao) {
		if (permissao.getDescricao().equals("administrador")) {
			autorizacaoAdministrador(pagina, permissao);
		}
		if (permissao.getDescricao().equals("vendedor")) {
			autorizacaoVendedor(pagina, permissao);
		}
		if (permissao.getDescricao().equals("aluno")) {
			autorizacaoAluno(pagina, permissao);
		}
		if (permissao.getDescricao().equals("coordenacao")) {
			autorizacaoCoordenador(pagina, permissao);
		}
		if (permissao.getDescricao().equals("professor")) {
			autorizacaoProfessor(pagina, permissao);
		}

	}

	public void autorizacaoAdministrador(String pagina, Permissao permissao) {
		if (!pagina.contains("/")) {
			throw new RuntimeException();
		}
	}

	public void autorizacaoProfessor(String pagina, Permissao permissao) {
		if (!pagina.contains("/turma/professor/")) {
			throw new RuntimeException();
		}
	}

	public void autorizacaoAluno(String pagina, Permissao permissao) {
		if ((!pagina.contains("/aluno")) || pagina.contains("/usuarioss")) {
			throw new RuntimeException();
		}
	}

	public void autorizacaoCoordenador(String pagina, Permissao permissao) {
		throw new RuntimeException();
	}

	public void autorizacaoVendedor(String pagina, Permissao permissao) {
		throw new RuntimeException();
	}
}
