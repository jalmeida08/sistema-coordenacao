package br.com.jsa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="tipoTelefone")
public class TipoTelefone implements Serializable{

	private static final long serialVersionUID = 614070448101148255L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoTelefone;
	
	private String descricaoTipoTelefone;

	@OneToMany(mappedBy="tipoTelefone")
	private List<Telefone> telefone = new ArrayList<Telefone>();

	@Version
	private Long versao;
	

	public Integer getIdTipoTelefone() {
		return idTipoTelefone;
	}

	public void setIdTipoTelefone(Integer idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	public String getDescricaoTipoTelefone() {
		return descricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

}
