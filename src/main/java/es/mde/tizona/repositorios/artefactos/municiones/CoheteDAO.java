package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.Cohete;
import es.mde.tizona.entidades.artefactos.Mina;

@RepositoryRestResource(path="cohetes"
,itemResourceRel="cohete"
,collectionResourceRel="cohetes")

public interface CoheteDAO extends JpaRepository<Cohete, Long>{

}
