package es.mde.SpringBasics.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;

@RepositoryRestResource(path="elementos"
						,itemResourceRel="elemento"
						,collectionResourceRel="elementos")
public interface ElementoDAO extends JpaRepository<Elemento, Integer>, ElementoDAOCustom{

	@RestResource(path = "nombre")
	List<Elemento> findByNombre(@Param("nombre") String nombre);

	
	
}
