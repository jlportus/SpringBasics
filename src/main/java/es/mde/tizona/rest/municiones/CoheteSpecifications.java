package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.Cohete;
import es.mde.tizona.entidades.artefactos.municiones.Cohete_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class CoheteSpecifications {

	static SearchSpecs<Cohete> specs = new SearchSpecs<Cohete>();

	private CoheteSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Cohete> createCoheteSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.stringEqualTo(searchCriteria.getColorBandaMotor(), Cohete_.colorBandaMotor);
	}

}
