package es.mde.tizona.repositorios.artefactos.municiones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.entidades.artefactos.municiones.Granada;

@RepositoryRestResource(path="granadas"
,itemResourceRel="granada"
,collectionResourceRel="granadas")

public interface GranadaDAO extends JpaRepository<Granada, Long>{

}
