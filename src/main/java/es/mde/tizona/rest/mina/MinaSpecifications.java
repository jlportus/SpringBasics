package es.mde.tizona.rest.mina;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.entidades.artefactos.minas.Mina_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SpecificationsDeArtefactos;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class MinaSpecifications {

	private MinaSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Mina> createMinaSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return materialEnvueltaEqualTo(searchCriteria.getMaterialEnvuelta())
				
				//comprobar los criterios de artefactoPadre
				.and(minasEnArtefactos(searchCriteria)) 
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
	public static Specification<Mina> minasEnArtefactos(SearchCriteriaDeArtefactos searchCriteria){
		return (Specification<Mina>) SpecificationsDeArtefactos.createArtefactoSpecifications(searchCriteria);
	}
}
