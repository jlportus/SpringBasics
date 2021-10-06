package es.mde.tizona.rest.mina;



import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.entidades.artefactos.minas.Mina_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;
//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MinaSpecifications {

	static SearchSpecs<Mina> specs = new SearchSpecs<Mina>();
	
	private MinaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Mina> createMinaSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return 		 specs.intBetween(searchCriteria.getDiametroMin(), searchCriteria.getDiametroMax(), Mina_.diametro)
				.and(specs.intBetween(searchCriteria.getFondoMin(), searchCriteria.getFondoMax(), Mina_.fondo))
				.and(specs.intBetween(searchCriteria.getLongitudMin(), searchCriteria.getLongitudMax(), Mina_.longitud))
				.and(specs.intBetween(searchCriteria.getAlturaMin(), searchCriteria.getAlturaMax(), Mina_.altura))
				.and(specs.stringEqualTo(searchCriteria.getMaterialEnvuelta(), Mina_.materialEnvuelta))
				.and(specs.stringEqualTo(searchCriteria.getSituacionEspoleta(), Mina_.situacionEspoleta))
				.and(specs.isBoolean(searchCriteria.getAsaTransporte(), Mina_.asaTransporte))
				.and(specs.stringEqualTo(searchCriteria.getSistemaIniciacion(), Mina_.sistemaIniciacion))
				.and(specs.stringEqualTo(searchCriteria.getTipoMina(), Mina_.tipoMina))				
				;
	}
	
}
