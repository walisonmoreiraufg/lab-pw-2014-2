package br.inf.ufg.pw.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Curso {
	@Id
	@GeneratedValue
	private Long id;

	private Long codigo;

	private String nome;
	
	@ManyToOne
	private Universidade universidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

}
