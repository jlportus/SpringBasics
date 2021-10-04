package es.mde.tizona.rest.mina;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.entidades.artefactos.minas.Mina_;
import es.mde.tizona.rest.ArtefactoSearchCriteria;
import es.mde.tizona.rest.ArtefactoSpecifications;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MinaSpecifications {

	private MinaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Mina> createMinaSpecifications(ArtefactoSearchCriteria searchCriteria) {
		System.err.println("estoy creando los criterios de mina");
		return materialEnvueltaEqualTo(searchCriteria.getMaterialEnvuelta())
				
				.and(minasEnArtefactos(searchCriteria)) //comprobar los criterios de artefactoPadre
				;
	}

	// declaro cada uno de los posibles criterios de busqueda que agrego al
	// createSpecifications
	public static Specification<Mina> materialEnvueltaEqualTo(Optional<String> materialEnvuelta) {
		return (root, query, builder) -> {
			return materialEnvuelta
					.map(envuelta -> builder.equal(root.get(Mina_.materialEnvuelta), String.valueOf(envuelta)))
					.orElse(null);
		};
	}
	
	//para que compruebe tambien los filtros de artefactoPadre
	public static Specification<Mina> minasEnArtefactos(ArtefactoSearchCriteria searchCriteria){
		return (Specification<Mina>) ArtefactoSpecifications.createArtefactoSpecifications(searchCriteria);
	}
}
