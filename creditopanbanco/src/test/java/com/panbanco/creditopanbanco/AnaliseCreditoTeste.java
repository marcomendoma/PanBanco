package com.panbanco.creditopanbanco;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panbanco.creditopanbanco.controller.CreditoController;
import com.panbanco.creditopanbanco.domain.CreditoRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class AnaliseCreditoTeste {
	
	private static final ObjectMapper om = new ObjectMapper();
	private CreditoRequest creditoRequest;

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	CreditoController creditoController;
	
	@Before
	public void setUp() {
	    mockMvc = MockMvcBuilders.standaloneSetup(creditoController).build();
	    
	    creditoRequest.setNome("Wesley Snow");
		creditoRequest.setValorPedido(new BigDecimal("1500"));
		creditoRequest.setQtdVezes(10);
	}
	
	@Test
    public void analiseCredito() throws Exception {
		
		ResultActions response = mockMvc.perform(post("/credito/calcular")
		        .content(om.writeValueAsString(creditoRequest))
		        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		response
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].quantidadeParcelas", is(10)))
            .andExpect(jsonPath("$[0].valorEmprestado", is(1746.25)))
            .andExpect(jsonPath("$[0].valorParcela", is(174.62)))
            .andExpect(jsonPath("$[0].nome", is("Wesley Snow")))
            .andExpect(jsonPath("$[0].salario", is(3175)))
            .andExpect(jsonPath("$[0].valorPedido", is(1500)));
    }
	
	@Test
    public void analiseCreditoNotFound_404() throws Exception {
		
		CreditoRequest creditoRequest = new CreditoRequest("Marco Antonio Mendonça", 0, new BigDecimal("0"), new BigDecimal("1500"), 10);
		
        mockMvc.perform(post("/credito/calcular")
	        .content(om.writeValueAsString(creditoRequest))
	        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
    }
}
