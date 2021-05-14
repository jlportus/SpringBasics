package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mde.SpringBasics.entidades.herencia.HijoHerencia;

@Repository
public interface HijoHerenciaDAO extends JpaRepository<HijoHerencia, Integer>{

}
