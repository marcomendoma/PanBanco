package com.panbanco.creditopanbanco.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

@Repository
public interface CalculaIdadePorcentagem {
	BigDecimal calcIdadePorcentagem();
}
