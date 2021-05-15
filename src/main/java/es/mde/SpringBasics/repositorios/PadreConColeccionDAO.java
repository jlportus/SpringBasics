package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

@RepositoryRestResource(path="coleccion"
					//,exported=false,
					,itemResourceRel="coleccion"
					,collectionResourceRel="colecciones")
public interface PadreConColeccionDAO extends JpaRepository<PadreConColeccion, Integer>{

}
