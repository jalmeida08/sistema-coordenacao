package br.com.jsa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="telefone")
@IdClass(TelefoneIdClass.class)
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1421489784066020419L;

	@Id
	private Long numero;
	@Id
	private Integer ddd;

	@Id
	@ManyToOne
	@JoinColumn(name = "idPessoa", insertable = false, updatable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name="idTipoTelefone")
	private TipoTelefone tipoTelefone;

	@Version
	private Long versao;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

}
