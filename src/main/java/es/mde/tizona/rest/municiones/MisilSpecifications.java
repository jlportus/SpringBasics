package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.Misil;
import es.mde.tizona.entidades.artefactos.municiones.Misil_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MisilSpecifications  {

	static SearchSpecs<Misil> specs = new SearchSpecs<Misil>();

	public MisilSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Misil> createMisilSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.stringEqualTo(searchCriteria.getSistemaGuia(), Misil_.sistemaGuia);
	}

}
