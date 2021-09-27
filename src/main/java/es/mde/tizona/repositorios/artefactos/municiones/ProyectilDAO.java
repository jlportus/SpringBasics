package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import es.mde.tizona.entidades.artefactos.Mina;
import es.mde.tizona.entidades.artefactos.Proyectil;

@RepositoryRestResource(path="proyectiles"
,itemResourceRel="proyectil"
,collectionResourceRel="proyectiles")

public interface ProyectilDAO extends JpaRepository<Proyectil, Long>{

}
