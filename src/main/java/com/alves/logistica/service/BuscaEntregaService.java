package com.alves.logistica.service;

import org.springframework.stereotype.Service;

import com.alves.logistica.exception.EntidadeNaoEncontradaException;
import com.alves.logistica.model.Entrega;
import com.alves.logistica.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega nao encontrada"));
	}

}
