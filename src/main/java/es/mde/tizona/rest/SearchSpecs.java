package es.mde.tizona.rest;

import java.util.Optional;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.rest.artefacto.ArtefactosSpecifications;
import es.mde.tizona.rest.mina.MinaSpecifications;

public class SearchSpecs<T> {

	// desde la interfazDAOImp llamare a este metodo con los criterios de Busqueda recibidos
	// Aqui de de llamar a los create specifications hijos pasandoles los criterios a cada uno 
	
	public static Specification<?> createSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return ((Specification<ArtefactoImpl>) minas(searchCriteria))
				.and((Specification<ArtefactoImpl>) artefactos(searchCriteria))
				;
	}

	// llamadas a las especificaciones hijas
	public static Specification<?> minas(SearchCriteriaDeArtefactos searchCriteria) {
		return MinaSpecifications.createMinaSpecifications(searchCriteria);
	}
	
	public static Specification<?> artefactos(SearchCriteriaDeArtefactos searchCriteria) {
		return ArtefactosSpecifications.createArtefactoSpecifications(searchCriteria);
	}
	
	// metodos tipos de comparacion, seran llamados por las Specifications de hijas 
	// hay que pasarle un parametro opcional del search cirteria y un atributo del metamodelo
	// para que funcionen se hace un objeto STATIC de SearchSpecs<tipoEnElqueSeBusque> en el specificactions hijo
	
	public Specification<T> stringEqualTo(Optional<String> string, SingularAttribute<T, String> atributo) {
		return (root, query, builder) -> {
			return string
					.map(cadena -> builder.equal(root.get(atributo), String.valueOf(cadena)))
					.orElse(null);
		};
	}

	public Specification<T> intBetween(Optional<Integer> minimo, Optional<Integer> maximo,
			SingularAttribute<T, Integer> atributo) {
		return (root, query, builder) -> {
			return minimo
					.map(min -> {
				return maximo
						.map(max -> builder.between(root.get(atributo), min, max))
						.orElse(null);
			}).orElse(null);
		};
	}

	public Specification<T> isBoolean(Optional<Boolean> asaTransporte, SingularAttribute<T, Boolean> atributo) {
		return (root, query, builder) -> {
			return asaTransporte
					.map(asa -> builder.equal(root.get(atributo), String.valueOf(asa)))
					.orElse(null);
		};
	}

	public SearchSpecs() {
		super();
	}

}