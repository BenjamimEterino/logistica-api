package com.alves.logistica.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OcorrenciaModel {
	
	
	private Long id;
	private String Descricao;
	private OffsetDateTime dataRegistro;
}
