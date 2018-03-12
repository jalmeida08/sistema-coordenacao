package br.com.jsa.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno extends Pessoa{

	private static final long serialVersionUID = 8800185587682262750L;
	
	@ManyToOne
	@JoinColumn(name="pessoa_idPessoa")
	private Vendedor vendedor;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
