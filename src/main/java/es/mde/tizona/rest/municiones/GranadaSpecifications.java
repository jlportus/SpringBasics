package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.Granada;
import es.mde.tizona.entidades.artefactos.municiones.Granada_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class GranadaSpecifications {

	static SearchSpecs<Granada> specs = new SearchSpecs<Granada>();

	private GranadaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Granada> createGranadaSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.stringEqualTo(searchCriteria.getMedioLanzamiento(), Granada_.medioLanzamiento);
	}

}
