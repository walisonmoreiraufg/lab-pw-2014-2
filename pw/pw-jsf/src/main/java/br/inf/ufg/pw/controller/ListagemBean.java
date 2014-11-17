package br.inf.ufg.pw.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.inf.ufg.pw.model.entities.Aluno;

@ManagedBean
public class ListagemBean {

	private List<Aluno> alunos;

	public List<Aluno> getAlunos() {
		if (alunos == null) {
		}
		return alunos;
	}

	public String excluir(Aluno aluno) {
		alunos = null;
		return "welcome";
	}
	
	public String salvar() {
		return null;
	}
}
