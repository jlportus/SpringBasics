package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

@Repository
public interface PadreConColeccionDAO extends JpaRepository<PadreConColeccion, Integer>{

}
