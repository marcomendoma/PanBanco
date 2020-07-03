package com.panbanco.creditopanbanco.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.panbanco.creditopanbanco.domain.CreditoRequest;
import com.panbanco.creditopanbanco.repository.CalculaIdadePorcentagem;

@Service
public class CalculaIdadePorcentagemService implements CalculaIdadePorcentagem {
	
	private CreditoRequest creditoRequest;
	
	public CalculaIdadePorcentagemService() {}
	
	public CalculaIdadePorcentagemService(CreditoRequest creditoRequest) {
		this.creditoRequest = creditoRequest;
	}
	
	@Override
	public BigDecimal calcIdadePorcentagem() {
		BigDecimal nRetorno = new BigDecimal(0);
		
		try {
			if (creditoRequest.getIdade() > 80) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.2")); //20;
			} else if (creditoRequest.getIdade() > 50) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.7")); //70;
			} else if (creditoRequest.getIdade() > 30) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.9")); //90;
			} else if (creditoRequest.getIdade() > 20) {
				nRetorno = creditoRequest.getSalario(); //100;
			}
		} catch (Exception e) {
			new Exception("Erro na rotina de calculaIdadePorcentagem.");
		}	

		return nRetorno;
	}

	public CreditoRequest getCreditoRequest() {
		return creditoRequest;
	}

	public void setCreditoRequest(CreditoRequest creditoRequest) {
		this.creditoRequest = creditoRequest;
	}
}
