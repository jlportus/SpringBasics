package es.mde.tizona.repositorios.artefactos.municiones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.minas.Mina;
import es.mde.tizona.entidades.artefactos.municiones.Municion;

@RepositoryRestResource(path="municiones"
,itemResourceRel="municion"
,collectionResourceRel="municiones")

public interface MunicionDAO extends JpaRepository<Municion, Long>{

}
