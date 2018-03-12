package br.com.jsa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Pessoa{

	private static final long serialVersionUID = -5950904851936149166L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="vendedor", orphanRemoval=false)
	private List<Aluno> aluno;
}
