package es.mde.SpringBasics.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

@RepositoryRestResource(path = "coleccion"
// ,exported=false,
		, itemResourceRel = "coleccion", collectionResourceRel = "colecciones")
public interface PadreConColeccionDAO extends JpaRepository<PadreConColeccion, Integer> {

	@Override
	@RestResource(exported = false)
	default void delete(PadreConColeccion entity) {
	}

	@RestResource(path = "nombre")
	List<PadreConColeccion> findByNombre(@Param("nombre") String nombre);

//	@RestResource(path = "borrarid")
//	void deleteById(@Param("id") Integer id);

}
