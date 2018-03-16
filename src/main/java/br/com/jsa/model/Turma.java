package br.com.jsa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name="turma")
public class Turma implements Serializable{

	private static final long serialVersionUID = -5497547719082629505L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int quantidadeAulas;
	private int aulaAtual;
	@OneToOne
	private Professor professor;
	@Version
	private Long versao;
	
}
