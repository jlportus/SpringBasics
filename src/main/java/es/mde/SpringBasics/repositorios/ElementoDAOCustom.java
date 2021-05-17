package es.mde.SpringBasics.repositorios;

import java.util.List;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;

public interface ElementoDAOCustom {

	List<Elemento> getPacos(String txt);
	
}
