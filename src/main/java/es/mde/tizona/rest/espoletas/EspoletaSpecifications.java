package es.mde.tizona.rest.espoletas;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.espoletas.Espoleta;
import es.mde.tizona.entidades.artefactos.espoletas.Espoleta_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class EspoletaSpecifications {

	static SearchSpecs<Espoleta> specs = new SearchSpecs<Espoleta>();

	private EspoletaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Espoleta> createEspoletaSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return 		 specs.intBetween(searchCriteria.getDiametroMin(), searchCriteria.getDiametroMax(), Espoleta_.diametro)
				.and(specs.intBetween(searchCriteria.getAlturaMin(), searchCriteria.getAlturaMax(), Espoleta_.altura))
				.and(specs.stringEqualTo(searchCriteria.getTipoIniciacion(), Espoleta_.tipoIniciacion)
				.and(specs.intBetween(searchCriteria.getProfundidadCavidadMin(), searchCriteria.getProfundidadCavidadMax(), Espoleta_.profundidadCavidad))
				.and(specs.stringEqualTo(searchCriteria.getTipoEspoleta(), Espoleta_.tipoEspoleta)))
				;
	}

}
