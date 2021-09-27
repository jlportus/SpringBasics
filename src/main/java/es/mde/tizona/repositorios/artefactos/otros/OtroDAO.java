package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import es.mde.tizona.entidades.artefactos.Mina;
import es.mde.tizona.entidades.artefactos.Otro;

@RepositoryRestResource(path="otros"
,itemResourceRel="otro"
,collectionResourceRel="otros")

public interface OtroDAO extends JpaRepository<Otro, Long>{

}
