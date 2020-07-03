package com.panbanco.creditopanbanco.domain;

import java.math.BigDecimal;

public class CreditoResponse {
	private String Nome;
	private BigDecimal Salario;
	private BigDecimal ValorPedido;
	private BigDecimal ValorEmprestado;
	private int QuantidadeParcelas;
	private BigDecimal ValorParcela;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public BigDecimal getSalario() {
		return Salario;
	}

	public void setSalario(BigDecimal salario) {
		Salario = salario;
	}

	public BigDecimal getValorPedido() {
		return ValorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		ValorPedido = valorPedido;
	}

	public BigDecimal getValorEmprestado() {
		return ValorEmprestado;
	}

	public void setValorEmprestado(BigDecimal valorEmprestado) {
		ValorEmprestado = valorEmprestado;
	}

	public int getQuantidadeParcelas() {
		return QuantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		QuantidadeParcelas = quantidadeParcelas;
	}

	public BigDecimal getValorParcela() {
		return ValorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		ValorParcela = valorParcela;
	}
	
	public CreditoResponse() {};

	public CreditoResponse(String nome, BigDecimal salario, BigDecimal valorPedido, BigDecimal valorEmprestado,
			int quantidadeParcelas, BigDecimal valorParcela) {
		super();
		Nome = nome;
		Salario = salario;
		ValorPedido = valorPedido;
		ValorEmprestado = valorEmprestado;
		QuantidadeParcelas = quantidadeParcelas;
		ValorParcela = valorParcela;
	}

	@Override
	public String toString() {
		return "CreditoResponse [Nome=" + Nome + ", Salario=" + Salario + ", ValorPedido=" + ValorPedido
				+ ", ValorEmprestado=" + ValorEmprestado + ", QuantidadeParcelas=" + QuantidadeParcelas
				+ ", ValorParcela=" + ValorParcela + "]";
	}
}
