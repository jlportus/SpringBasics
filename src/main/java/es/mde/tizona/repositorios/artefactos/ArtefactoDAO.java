package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.ArtefactoImpl;

@RepositoryRestResource(path="artefactos"
						,itemResourceRel="artefacto"
						,collectionResourceRel="artefactos")
public interface ArtefactoDAO extends JpaRepository<ArtefactoImpl, Long> {

}
