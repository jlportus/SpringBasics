package es.mde.tizona.rest;

import java.util.Optional;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;
import es.mde.tizona.rest.artefacto.ArtefactosSpecifications;
import es.mde.tizona.rest.espoletas.EspoletaSpecifications;
import es.mde.tizona.rest.mina.MinaSpecifications;
import es.mde.tizona.rest.municiones.BombaAviacionSpecifications;
import es.mde.tizona.rest.municiones.CoheteSpecifications;
import es.mde.tizona.rest.municiones.GranadaSpecifications;
import es.mde.tizona.rest.municiones.MisilSpecifications;
import es.mde.tizona.rest.municiones.MunicionSpecifications;
import es.mde.tizona.rest.municiones.ProyectilSpecifications;
import es.mde.tizona.rest.otro.OtroSpecifications;

public class SearchSpecs<T> {

	//con el and hago un join de todas las espedificaciones que llamo en sus respectivos metodos pasando los criterios a todos
	// si no hago el casteo, me dice que me devuelven tipos diferentes y peta
	
	public static Specification<?> createSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return 		((Specification<ArtefactoImpl>) artefactos(searchCriteria))
				.and((Specification<ArtefactoImpl>) minas(searchCriteria))
				.and((Specification<ArtefactoImpl>) municiones(searchCriteria))
				.and((Specification<ArtefactoImpl>) proyectiles(searchCriteria))
				.and((Specification<ArtefactoImpl>) bombasAviacion(searchCriteria))
				.and((Specification<ArtefactoImpl>) cohetes(searchCriteria))
				.and((Specification<ArtefactoImpl>) misiles(searchCriteria))
				.and((Specification<ArtefactoImpl>) granadas(searchCriteria))
				.and((Specification<ArtefactoImpl>) espoletas(searchCriteria))
				.and((Specification<ArtefactoImpl>) otros(searchCriteria))
				;
	}

	// llamadas a las especificaciones hijas
	public static Specification<?> artefactos(SearchCriteriaDeArtefactos searchCriteria) {
		return ArtefactosSpecifications.createArtefactoSpecifications(searchCriteria);
	}
	
	public static Specification<?> minas(SearchCriteriaDeArtefactos searchCriteria) {
		return MinaSpecifications.createMinaSpecifications(searchCriteria);
	}
		
	public static Specification<?> municiones(SearchCriteriaDeArtefactos searchCriteria) {
		return MunicionSpecifications.createMunicionesSpecifications(searchCriteria);
	}
	
	public static Specification<?> proyectiles(SearchCriteriaDeArtefactos searchCriteria) {
		return ProyectilSpecifications.createProyectilSpecifications(searchCriteria);
	}
	
	public static Specification<?> bombasAviacion(SearchCriteriaDeArtefactos searchCriteria) {
		return BombaAviacionSpecifications.createBombasAviacionSpecifications(searchCriteria);
	}
	
	public static Specification<?> cohetes(SearchCriteriaDeArtefactos searchCriteria) {
		return CoheteSpecifications.createCoheteSpecifications(searchCriteria);
	}
	
	public static Specification<?> misiles(SearchCriteriaDeArtefactos searchCriteria) {
		return MisilSpecifications.createMisilSpecifications(searchCriteria);
	}
	
	public static Specification<?> granadas(SearchCriteriaDeArtefactos searchCriteria) {
		return GranadaSpecifications.createGranadaSpecifications(searchCriteria);
	}
	
	public static Specification<?> espoletas(SearchCriteriaDeArtefactos searchCriteria) {
		return EspoletaSpecifications.createEspoletaSpecifications(searchCriteria);
	}
	
	public static Specification<?> otros(SearchCriteriaDeArtefactos searchCriteria) {
		return OtroSpecifications.createOtroSpecifications(searchCriteria);
	}
	
	// metodos tipos de comparacion, seran llamados por las Specifications de hijas 
	// hay que pasarle un parametro opcional del search cirteria y un atributo del metamodelo
	// para que acceder a ellos desde los specifications hijos se hace un objeto STATIC de SearchSpecs<tipoEnElqueSeBusque>  
	
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

	public Specification<T> isBoolean(Optional<Boolean> booleano, SingularAttribute<T, Boolean> atributo) {
		return (root, query, builder) -> {
			return booleano
					.map(valor -> builder.equal(root.get(atributo), valor))
					.orElse(null);	
			};
	}

	public SearchSpecs() {
		super();
	}

}