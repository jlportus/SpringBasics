package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import es.mde.tizona.entidades.artefactos.Mina;

@RepositoryRestResource(path="minas"
,itemResourceRel="mina"
,collectionResourceRel="minas")

public interface MinaDAO extends JpaRepository<Mina, Long>{

}
