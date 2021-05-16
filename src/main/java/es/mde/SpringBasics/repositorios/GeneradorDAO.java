package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.SpringBasics.entidades.entidadesConListeners.Generador;

@RepositoryRestResource(path="generador"
						,itemResourceRel="generado"
						,collectionResourceRel="generados")
public interface GeneradorDAO extends JpaRepository<Generador, Integer>{

}
