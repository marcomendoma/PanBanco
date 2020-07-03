package com.panbanco.creditopanbanco.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.panbanco.creditopanbanco.domain.CreditoRequest;
import com.panbanco.creditopanbanco.repository.CalculaSalarioPorcentagem;
import com.panbanco.creditopanbanco.utils.CompararIntervalo;

@Service
public class CalculaSalarioPorcentagemService implements CalculaSalarioPorcentagem {
	
	private CreditoRequest creditoRequest;
	
	public CalculaSalarioPorcentagemService() {}
	
	public CalculaSalarioPorcentagemService(CreditoRequest creditoRequest) {
		this.creditoRequest = creditoRequest;
	}
	
	@Override
	public BigDecimal calcSalarioPorcentagem() {
		BigDecimal nRetorno = new BigDecimal(0);
		
		try {
			if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(1000), new BigDecimal(2000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.05")); // 5%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(2001), new BigDecimal(3000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.1")); // 10%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(3001), new BigDecimal(4000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.15")); // 15%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(4001), new BigDecimal(5000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.2")); // 20%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(5001), new BigDecimal(6000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.25")); // 25%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(6001), new BigDecimal(7000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.3")); // 30%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(7001), new BigDecimal(8000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.35")); // 35%
			} else if (CompararIntervalo.isBetween(creditoRequest.getSalario(), new BigDecimal(8001), new BigDecimal(9000)) == true) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.4")); // 40%
			} else if (creditoRequest.getSalario().compareTo(new BigDecimal("9001")) > 0) {
				nRetorno = creditoRequest.getSalario().multiply(new BigDecimal("0.45")); // 45%
			}
		} catch (Exception e) {
			new Exception("Erro na rotina de calculaSalarioPorcentagem.");
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
