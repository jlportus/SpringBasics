package es.mde.SpringBasics.repositorios;

import java.util.Collection;

import javax.persistence.OneToMany;

import es.mde.SpringBasics.entidades.oneToMany.Elemento;
import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;

public class PadreConColeccionImpl extends PadreConColeccion{

	@Override
	@OneToMany(targetEntity = Elemento.class)
	public Collection<Elemento> getListadoElementos() {
		return super.getListadoElementos();
	}
}
