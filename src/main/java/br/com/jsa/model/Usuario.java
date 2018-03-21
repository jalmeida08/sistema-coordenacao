package br.com.jsa.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2500244136796891393L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	private String email;
	private String senha;
	private boolean senhaAleatoria;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_permissao",
		joinColumns = {@JoinColumn(name="idUsuario", referencedColumnName="idUsuario")},
		inverseJoinColumns = {@JoinColumn (name="idPermissao", referencedColumnName="idPermissao")})
	private List<Permissao> permissao;
	
	@Version
	private Long versao;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			this.senha = hexString.toString();
		} catch (Exception e) {
			
		}

	}

	public boolean isSenhaAleatoria() {
		return senhaAleatoria;
	}

	public void setSenhaAleatoria(boolean senhaAleatoria) {
		this.senhaAleatoria = senhaAleatoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Permissao> getPermissao() {
		return permissao;
	}

	public void setPermissao(List<Permissao> permissao) {
		this.permissao = permissao;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

}
