package br.inf.ufg.pw.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TempBean {

	private String test = "teste";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
