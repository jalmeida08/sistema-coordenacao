package br.com.jsa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity(name="permissao")
public class Permissao implements Serializable{

	private static final long serialVersionUID = -2534230192451629565L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPermissao;
	private String descricao;
	@ManyToMany(mappedBy="permissao")
	private List<Usuario> usuario = new ArrayList<Usuario>();
	
	@Version
	private Long versao;
	
	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}
	
}
