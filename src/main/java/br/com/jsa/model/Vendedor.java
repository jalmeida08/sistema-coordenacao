package br.com.jsa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Pessoa{

	private static final long serialVersionUID = -5950904851936149166L;

	@OneToMany(mappedBy="vendedor", orphanRemoval=false)
	private List<Aluno> aluno = new ArrayList<Aluno>();
}
