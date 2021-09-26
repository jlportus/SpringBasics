package es.mde.tizona.repositorios.artefactos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.BombaAviacion;
import es.mde.tizona.entidades.artefactos.Mina;

@RepositoryRestResource(path="bombasAviacion"
,itemResourceRel="bombaAviacion"
,collectionResourceRel="bombasAviacion")

public interface BombaAviacionDAO extends JpaRepository<BombaAviacion, Long>{

}
