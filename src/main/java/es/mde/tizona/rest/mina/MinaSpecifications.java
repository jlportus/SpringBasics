package es.mde.tizona.rest.mina;

import java.util.Optional;

import javax.persistence.metamodel.SingularAttribute;

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
		return intBetween(searchCriteria.getDiametroMin(), searchCriteria.getDiametroMax(), Mina_.diametro)
				.and(intBetween(searchCriteria.getAlturaMin(), searchCriteria.getAlturaMax(), Mina_.altura))
				.and(intBetween(searchCriteria.getFondoMin(), searchCriteria.getFondoMax(), Mina_.fondo))
				.and(intBetween(searchCriteria.getLongitudMin(), searchCriteria.getLongitudMax(), Mina_.longitud))
				.and(materialEnvueltaEqualTo(searchCriteria.getMaterialEnvuelta()))
				.and(situacionEspoletaEqualTo(searchCriteria.getSituacionEspoleta()))
				.and(isAsaDeTransporte(searchCriteria.getAsaTransporte()))
				.and(sistemaIniciacionEqualTo(searchCriteria.getSistemaIniciacion()))
				.and(tipoMInaEqualTo(searchCriteria.getTipoMina()))
				//comprobar los criterios de artefactoPadre
				.and(minasEnArtefactos(searchCriteria)) 
				;
	}

	// declaro cada uno de los posibles criterios de busqueda que agrego al
	// createSpecifications
	
	public static Specification<Mina> intBetween(Optional<Integer> minimo, Optional<Integer> maximo, SingularAttribute<Mina, Integer> atributo) {
		return (root, query, builder) -> {
			return minimo.
					map(min -> {
						return maximo
								.map(max -> builder.between(root.get(atributo), min, max))
						.orElse(null);
			}).orElse(null);
		};
	}
	
	public static Specification<Mina> materialEnvueltaEqualTo(Optional<String> materialEnvuelta) {
		return (root, query, builder) -> {
			return materialEnvuelta
					.map(envuelta -> builder.equal(root.get(Mina_.materialEnvuelta), String.valueOf(envuelta)))
					.orElse(null);
		};
	}
	
	public static Specification<Mina> situacionEspoletaEqualTo(Optional<String> situacionEspoleta) {
		return (root, query, builder) -> {
			return situacionEspoleta
					.map(situacion -> builder.equal(root.get(Mina_.situacionEspoleta), String.valueOf(situacion)))
					.orElse(null);
		};
	}
	
	public static Specification<Mina> isAsaDeTransporte(Optional<Boolean> asaTransporte) {
		return (root, query, builder) -> {
			return asaTransporte
					.map(asa -> builder.equal(root.get(Mina_.asaTransporte), String.valueOf(asa)))
					.orElse(null);
		};
	}
	
	public static Specification<Mina> sistemaIniciacionEqualTo(Optional<String> sistemaIniciacion) {
		return (root, query, builder) -> {
			return sistemaIniciacion
					.map(sisIni -> builder.equal(root.get(Mina_.sistemaIniciacion), String.valueOf(sisIni)))
					.orElse(null);
		};
	}
	
	public static Specification<Mina> tipoMInaEqualTo(Optional<String> tipoMina) {
		return (root, query, builder) -> {
			return tipoMina
					.map(tipo -> builder.equal(root.get(Mina_.tipoMina), String.valueOf(tipo)))
					.orElse(null);
		};
	}
	
	//para que compruebe tambien los filtros de artefactoPadre
	public static Specification<Mina> minasEnArtefactos(SearchCriteriaDeArtefactos searchCriteria){
		return (Specification<Mina>) SpecificationsDeArtefactos.createArtefactoSpecifications(searchCriteria);
	}
}
