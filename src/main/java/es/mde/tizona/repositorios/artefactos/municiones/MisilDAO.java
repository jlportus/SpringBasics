package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import es.mde.tizona.entidades.artefactos.Mina;
import es.mde.tizona.entidades.artefactos.Misil;

@RepositoryRestResource(path="misiles"
,itemResourceRel="misil"
,collectionResourceRel="misiles")

public interface MisilDAO extends JpaRepository<Misil, Long>{

}
