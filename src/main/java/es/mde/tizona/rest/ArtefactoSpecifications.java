package es.mde.tizona.rest;

import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl_;

public class ArtefactoSpecifications {

	private ArtefactoSpecifications() {
	}

	public static Specification<ArtefactoImpl> createArtefactoSpecifications(ArtefactoSearchCriteria searchCriteria) {
		return formaEqualTo(searchCriteria.getForma());
	}

	public static Specification<ArtefactoImpl> formaEqualTo(Optional<String> forma) {
		return null;// (root, query, builder) -> {
//			return forma.map(form -> builder.equal(root.get(ArtefactoImpl_.forma), String.valueOf(form))).orElse(null);
//		};
	}
}
