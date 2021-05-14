package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;

@Repository
public interface ElementoDAO extends JpaRepository<Elemento, Integer>{

}
