package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.Municion;
import es.mde.tizona.entidades.artefactos.municiones.Municion_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MunicionesSpecifications {

	static SearchSpecs<Municion> specs = new SearchSpecs<Municion>();

	private MunicionesSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Municion> createMunicionesSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.intBetween(searchCriteria.getCalibreMin(), searchCriteria.getCalibreMax(), Municion_.calibre)
				.and(specs.intBetween(searchCriteria.getLongitudMin(), searchCriteria.getLongitudMax(),
						Municion_.longitud))
				.and(specs.stringEqualTo(searchCriteria.getProposito(), Municion_.proposito))
				.and(specs.isBoolean(searchCriteria.getAsaTransporte(), Municion_.aletas));
	}

}
