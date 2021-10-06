package es.mde.tizona.rest.municiones;

import org.springframework.data.jpa.domain.Specification;

import es.mde.tizona.entidades.artefactos.municiones.Proyectil;
import es.mde.tizona.entidades.artefactos.municiones.Proyectil_;
import es.mde.tizona.rest.SearchCriteriaDeArtefactos;
import es.mde.tizona.rest.SearchSpecs;

//En esta clase se aniaden los diferentes posibles criterios de busqueda
public class ProyectilSpecifications {

	static SearchSpecs<Proyectil> specs = new SearchSpecs<Proyectil>();

	private ProyectilSpecifications() {
	}

	// Aniado los criterios posibles de busqueda a las especificaciones
	public static Specification<Proyectil> createProyectilSpecifications(SearchCriteriaDeArtefactos searchCriteria) {
		return specs.stringEqualTo(searchCriteria.getDibujoBajoBandaConduccion(), Proyectil_.dibujoBajoBandaConduccion);
	}

}
