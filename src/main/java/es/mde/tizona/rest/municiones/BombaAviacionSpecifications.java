package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.BombaAviacion;
import es.mde.tizona.entidades.artefactos.municiones.BombaAviacion_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class BombaAviacionSpecifications {

	static SearchSpecs<BombaAviacion> specs = new SearchSpecs<BombaAviacion>();

	private BombaAviacionSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<BombaAviacion> createBombasAviacionSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return 		 specs.isBoolean(searchCriteria.getPinturaProteccionTermica(), BombaAviacion_.pinturaProteccionTermica)
				.and(specs.intBetween(searchCriteria.getDistanciaAnillasMin(), searchCriteria.getDistanciaAnillasMax(), BombaAviacion_.distanciaAnillas))
				.and(specs.stringEqualTo(searchCriteria.getTipoEstabilizador(), BombaAviacion_.tipoEstabilizador))
				.and(specs.isBoolean(searchCriteria.getVenterolEnEstabilizador(), BombaAviacion_.venterolEnEstabilizador));
	}

}
