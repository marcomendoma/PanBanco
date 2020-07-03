package com.panbanco.creditopanbanco.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.panbanco.creditopanbanco.domain.CreditoRequest;
import com.panbanco.creditopanbanco.domain.CreditoResponse;

@Service
public class CalculaCreditoService {
	
	private CreditoRequest creditoRequest;

	public CalculaCreditoService() {}
	
	public CalculaCreditoService(CreditoRequest creditoRequest) {
		this.creditoRequest = creditoRequest;
	}
	
	public CreditoResponse retornaValorCredito() {
		CreditoResponse creditoResponse = new CreditoResponse();
		
		try {
			BigDecimal bgSalarioPorcentagem = new CalculaSalarioPorcentagemService(creditoRequest)
													.calcSalarioPorcentagem()
													.setScale(2, RoundingMode.HALF_EVEN);
			
			BigDecimal bgIdadePorcentagem = new CalculaIdadePorcentagemService(creditoRequest)
													.calcIdadePorcentagem()
													.setScale(2, RoundingMode.HALF_EVEN);

			BigDecimal bgValorEmprestimo = bgIdadePorcentagem 
													.subtract(bgSalarioPorcentagem);
			
			creditoResponse.setValorParcela(bgValorEmprestimo
													.divide(new BigDecimal(creditoRequest.getQtdVezes()))
													.setScale(2, RoundingMode.HALF_EVEN));
			
			creditoResponse.setValorEmprestado(bgValorEmprestimo);
			creditoResponse.setSalario(creditoRequest.getSalario());
			creditoResponse.setQuantidadeParcelas(creditoRequest.getQtdVezes());
			creditoResponse.setNome(creditoRequest.getNome());
			creditoResponse.setValorPedido(creditoRequest.getValorPedido());
			
		} catch (Exception e) {
			new Exception("Erro na rotina retornaValor.");
		}
		
		return creditoResponse;
	}

	public CreditoRequest getCreditoRequest() {
		return creditoRequest;
	}

	public void setCreditoRequest(CreditoRequest creditoRequest) {
		this.creditoRequest = creditoRequest;
	}
}
