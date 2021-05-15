package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.SpringBasics.entidades.singletable.Hijo;

@RepositoryRestResource(path = "singletable"
						,itemResourceRel = "hijo"
						, collectionResourceRel = "hijes")
public interface HijoDAO extends JpaRepository<Hijo, Integer>{

}
