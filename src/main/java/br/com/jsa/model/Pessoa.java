package br.com.jsa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name="pessoa")
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = -7845503815781776248L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idPessoa")
	private Usuario usuario;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pessoa",cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Telefone> telefone = new ArrayList<Telefone>();

	@Version
	private Long versao;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	

}
