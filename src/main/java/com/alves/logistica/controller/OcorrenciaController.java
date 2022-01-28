package com.alves.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alves.logistica.api.assembler.OcorrenciaAssembler;
import com.alves.logistica.api.model.OcorrenciaModel;
import com.alves.logistica.api.model.input.OcorrenciaInput;
import com.alves.logistica.model.Entrega;
import com.alves.logistica.model.Ocorrencia;
import com.alves.logistica.service.BuscaEntregaService;
import com.alves.logistica.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private BuscaEntregaService buscaEntregaService;
		private RegistroOcorrenciaService registroOcorrenciaService;
		private OcorrenciaAssembler ocorrenciaAssembler;
		
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public OcorrenciaModel registra(@PathVariable Long entregaId,
				@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
			
			Ocorrencia ocorrenciaRegistrada = 
					registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
			
			return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
		}
		
		
		@GetMapping
		public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
			Entrega entrega = buscaEntregaService.buscar(entregaId);
			
			return ocorrenciaAssembler.toCollectionModel(entrega.getOccorencias());
		}
		
		
}
