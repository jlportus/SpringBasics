package es.mde.tizona.rest;

import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl_;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class ArtefactoSpecifications {

	private ArtefactoSpecifications() {
	}

	//Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<ArtefactoImpl> createArtefactoSpecifications(ArtefactoSearchCriteria searchCriteria) {
		return formaEqualTo(searchCriteria.getForma());
	}

	//declaro cada uno de los posibles criterios de busqueda que agrego al createSpecifications
	public static Specification<ArtefactoImpl> formaEqualTo(Optional<String> forma) {
		return (root, query, builder) -> {
			return forma.map(form -> builder.equal(root.get(ArtefactoImpl_.forma), String.valueOf(form))).orElse(null);
		};
	}
}
