package es.mde.tizona.rest;

import java.util.Optional;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchCriteriaDeArtefactos {

	// Criterios comunes de artefactos
	
	private Optional<String> forma;
	private Optional<String> color;
	private Optional<String> fabricacion;
	private Set<String> encontradoEn;
	private Optional<String> marcasFrio;
	private Optional<String> marcasPintura;
	
	
	// criterios especificos de Minas
	private Optional<String> materialEnvuelta;

}
