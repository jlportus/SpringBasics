package es.mde.tizona.repositorios.artefactos.espoletas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.tizona.entidades.artefactos.espoletas.Espoleta;
import es.mde.tizona.entidades.artefactos.minas.Mina;

@RepositoryRestResource(path="espoletas"
,itemResourceRel="espoleta"
,collectionResourceRel="espoletas")

public interface EspoletaDAO extends JpaRepository<Espoleta, Long>{

}
