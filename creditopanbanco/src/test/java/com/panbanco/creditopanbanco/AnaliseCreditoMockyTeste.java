package com.panbanco.creditopanbanco;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.panbanco.creditopanbanco.controller.CreditoController;
import com.panbanco.creditopanbanco.domain.CreditoRequest;
import com.panbanco.creditopanbanco.domain.CreditoResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class AnaliseCreditoMockyTeste {

	private CreditoRequest creditoRequest;
	
	@Autowired
	CreditoController creditoController;
	
	@Before
	public void Inicializa() {
		creditoRequest.setNome("Wesley Snow");
		creditoRequest.setValorPedido(new BigDecimal("1500"));
		creditoRequest.setQtdVezes(10);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void analiseCreditoTeste() {
		ResponseEntity<CreditoResponse> resultado = creditoController.retornaCredito(creditoRequest);

        assertThat(resultado.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(resultado.getHeaders().getContentType(), is(equalTo(MediaType.APPLICATION_JSON)));
        assertThat(resultado.getBody().getQuantidadeParcelas(), is(equalTo(10)));
        assertThat(resultado.getBody().getValorEmprestado(), is(equalTo(1746.25)));
        assertThat(resultado.getBody().getValorParcela(), is(equalTo(174.62)));
        assertThat(resultado.getBody().getNome(), is(equalTo("Wesley Snow")));
        assertThat(resultado.getBody().getValorPedido(), is(equalTo(1500)));
	}
}
