package com.panbanco.creditopanbanco.controller;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.panbanco.creditopanbanco.domain.CreditoRequest;
import com.panbanco.creditopanbanco.domain.CreditoResponse;
import com.panbanco.creditopanbanco.domain.PessoaResponse;
import com.panbanco.creditopanbanco.service.CalculaCreditoService;

@RestController
@CrossOrigin("${origem-permitida}")
@RequestMapping("/credito")
public class CreditoController {
	public static final Logger logger = LoggerFactory.getLogger(CreditoController.class);

	@PostMapping("/calcular")
	public CreditoResponse retornaCredito(@RequestBody CreditoRequest creditoRequest) {
		ResponseEntity<PessoaResponse[]> pessoas = null; 
		Optional<PessoaResponse> pessoa = null;
		CreditoResponse creditoResponse = null;
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			pessoas = restTemplate.getForEntity("http://www.mocky.io/v2/5e5ec624310000b738afd85a", PessoaResponse[].class);
	        
	        pessoa = Arrays.asList(pessoas.getBody())
	        		.stream().filter(c-> creditoRequest.getNome()
	        		.equals(c.Nome.toString()))
	        		.findFirst(); 
	        
	        if (pessoa != null) {
	        	creditoRequest.setIdade(pessoa.get().getIdade());
	        	creditoRequest.setSalario(pessoa.get().getSalario());
	        	
	        	CalculaCreditoService calculaCreditoService = new CalculaCreditoService(creditoRequest);
	        	creditoResponse = calculaCreditoService.retornaValorCredito();
	        }
		} catch (Exception be) {
			logger.error("Erro ao Listar pessoas " + be.getMessage());
			new Exception("Erro na rotina de Listar pessoas. " + be.getMessage());
		}
		
		return creditoResponse;
	}
}
