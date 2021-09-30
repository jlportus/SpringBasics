package es.mde.tizona.repositorios.artefactos;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.Nullable;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@RepositoryRestResource(path = "artefactos", itemResourceRel = "artefacto", collectionResourceRel = "artefactos")
public interface ArtefactoDAO extends JpaRepository<ArtefactoImpl, Long>, JpaSpecificationExecutor<ArtefactoImpl> {

//	@EntityGraph( //ver carga de subtablas, multiples consultas anidadas
//				type = EntityGraphType.FETCH, 
//				attributePaths = { 
//						"language", 
//						"filmActors", 
//						"filmActors.actor" 
//						})
	List<ArtefactoImpl> findAll(@Nullable Specification<ArtefactoImpl> spec);
}
