package es.mde.tizona.rest.artefacto;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class ArtefactosSpecifications {

	static SearchSpecs<ArtefactoImpl> specs = new SearchSpecs<ArtefactoImpl>();

	private ArtefactosSpecifications() {
		super();
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<ArtefactoImpl> createArtefactoSpecifications(
			SearchCriteriaDeArtefactos searchCriteria) {
		return 		 specs.stringEqualTo(searchCriteria.getForma(), ArtefactoImpl_.forma)
				.and(specs.stringEqualTo(searchCriteria.getColor(), ArtefactoImpl_.color))
				.and(specs.stringEqualTo(searchCriteria.getFabricacion(), ArtefactoImpl_.fabricacion))
				.and(specs.stringEqualTo(searchCriteria.getMarcasFrio(), ArtefactoImpl_.marcasFrio))
				.and(specs.stringEqualTo(searchCriteria.getMarcasPintura(), ArtefactoImpl_.marcasPintura));
	}

}
