package es.mde.tizona.rest.mina;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl_;
import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.rest.ArtefactoSearchCriteria;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MinaSpecifications {

	private MinaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Mina> createMinaSpecifications(ArtefactoSearchCriteria searchCriteria) {
		System.err.println("estoy creando los criterios de mina");
		return materialEnvueltaEqualTo(searchCriteria.getMaterialEnvuelta())
				;
	}

	// declaro cada uno de los posibles criterios de busqueda que agrego al
	// createSpecifications

	public static Specification<Mina> materialEnvueltaEqualTo(Optional<String> materialEnvuelta) {
		return (root, query, builder) -> {
			return materialEnvuelta
					.map(envuelta -> builder.equal(root.get(ArtefactoImpl_.materialEnvuelta), String.valueOf(envuelta)))
					.orElse(null);
		};
	}
}
