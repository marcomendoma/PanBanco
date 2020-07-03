package com.panbanco.creditopanbanco.domain;

import java.math.BigDecimal;

public class PessoaResponse {

	public String Nome;
	public int Idade;
	public BigDecimal Salario;

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int Idade) {
		this.Idade = Idade;
	}

	public BigDecimal getSalario() {
		return Salario;
	}

	public void setSalario(BigDecimal Salario) {
		this.Salario = Salario;
	}

	public PessoaResponse() {
	}

	public PessoaResponse(String Nome, int Idade, BigDecimal Salario) {
		this.Nome = Nome;
		this.Idade = Idade;
		this.Salario = Salario;
	}

	@Override
	public String toString() {
		return "PessoaResponse [nome=" + Nome + ", idade=" + Idade + ", salario=" + Salario + "]";
	}
}
