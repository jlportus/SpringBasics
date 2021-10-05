package es.mde.tizona.rest;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.entidades.artefactos.ArtefactoImpl_;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class SpecificationsDeArtefactos {

	private SpecificationsDeArtefactos() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	
	//criterios Comunes de todos los artefactos
	//uso los getters, no son necesarios en la clase searcriteria, los autogenera Lombok con @Getter/@Setter
	public static Specification<?> createArtefactoSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return formaEqualTo(searchCriteria.getForma())
				.and(colorEqualTo(searchCriteria.getColor()))
				.and(fabricacionEqualTo(searchCriteria.getFabricacion()))
				.and(marcasFrioEqualTo(searchCriteria.getMarcasFrio()))
				.and(marcasPinturaEqualTo(searchCriteria.getMarcasPintura()))
		;
	}

	// declaro cada uno de los posibles criterios de busqueda que agrego al createSpecifications
	
	//criterios Comunes de todos los artefactos
	public static Specification<ArtefactoImpl> formaEqualTo(Optional<String> forma) {
		return (root, query, builder) -> {
			return forma
					.map(form -> builder.equal(root.get(ArtefactoImpl_.forma), String.valueOf(form)))
					.orElse(null);
		};
	}

	public static Specification<ArtefactoImpl> colorEqualTo(Optional<String> color) {
		return (root, query, builder) -> {
			return color
					.map(coloreado -> builder.equal(root.get(ArtefactoImpl_.color), String.valueOf(coloreado)))
					.orElse(null);
		};
	}

	public static Specification<ArtefactoImpl> fabricacionEqualTo(Optional<String> fabricacion) {
		return (root, query, builder) -> {
			return fabricacion
					.map(fabricado -> builder.equal(root.get(ArtefactoImpl_.fabricacion), String.valueOf(fabricado)))
					.orElse(null);
		};
	}

	public static Specification<ArtefactoImpl> marcasFrioEqualTo(Optional<String> marcasFrio) {
		return (root, query, builder) -> {
			return marcasFrio
					.map(marcado -> builder.equal(root.get(ArtefactoImpl_.marcasFrio), String.valueOf(marcado)))
					.orElse(null);
		};
	}

	public static Specification<ArtefactoImpl> marcasPinturaEqualTo(Optional<String> marcasPintura) {
		return (root, query, builder) -> {
			return marcasPintura
					.map(pintado -> builder.equal(root.get(ArtefactoImpl_.marcasPintura), String.valueOf(pintado)))
					.orElse(null);
		};
	}
}
