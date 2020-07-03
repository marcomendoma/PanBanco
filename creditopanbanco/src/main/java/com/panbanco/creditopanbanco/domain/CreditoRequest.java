package com.panbanco.creditopanbanco.domain;

import java.math.BigDecimal;

public class CreditoRequest {
	
	private String Nome;
	private int Idade;
	private BigDecimal Salario;
	private BigDecimal valorPedido;
	private int qtdVezes;

	public CreditoRequest() {}
	
	public CreditoRequest(String nome, int Idade, BigDecimal Salario, BigDecimal valorPedido, int qtdVezes) {
		this.Nome = nome;
		this.Idade = Idade; 
		this.Salario = Salario;
		this.valorPedido = valorPedido;
		this.qtdVezes = qtdVezes;
	}
	
	public int getQtdVezes() {
		return qtdVezes;
	}

	public void setQtdVezes(int qtdVezes) {
		this.qtdVezes = qtdVezes;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}

	public BigDecimal getSalario() {
		return Salario;
	}

	public void setSalario(BigDecimal salario) {
		Salario = salario;
	}
}
