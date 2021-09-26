package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.Granada;
import es.mde.tizona.entidades.artefactos.Mina;

@RepositoryRestResource(path="granadas"
,itemResourceRel="granada"
,collectionResourceRel="granadas")

public interface GranadaDAO extends JpaRepository<Granada, Long>{

}
