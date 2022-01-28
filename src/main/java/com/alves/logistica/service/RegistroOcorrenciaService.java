package com.alves.logistica.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alves.logistica.model.Entrega;
import com.alves.logistica.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}

}
