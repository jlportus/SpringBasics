package es.mde.tizona.rest.otro;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.otros.Otro;
import es.mde.tizona.entidades.artefactos.otros.Otro_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class OtroSpecifications {

	static SearchSpecs<Otro> specs = new SearchSpecs<Otro>();

	public OtroSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Otro> createOtroSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.stringEqualTo(searchCriteria.getProposito(), Otro_.proposito);
	}

}
