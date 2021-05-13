package es.mde.SpringBasics.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mde.SpringBasics.entidades.POJO.UsuarioAnotaciones;
import es.mde.SpringBasics.entidades.POJO.UsuarioXML;

@Repository
public interface UsuarioXMLDAO extends JpaRepository<UsuarioXML, Integer>{

}
