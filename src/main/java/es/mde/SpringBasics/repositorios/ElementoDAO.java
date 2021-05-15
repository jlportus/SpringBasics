package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;

@RepositoryRestResource(path="elemento"
						,itemResourceRel="elemento"
						,collectionResourceRel="elementos")
public interface ElementoDAO extends JpaRepository<Elemento, Integer>{

}
